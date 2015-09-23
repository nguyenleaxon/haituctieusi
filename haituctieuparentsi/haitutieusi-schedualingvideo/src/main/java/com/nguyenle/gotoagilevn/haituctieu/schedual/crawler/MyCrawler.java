package com.nguyenle.gotoagilevn.haituctieu.schedual.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Video;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;


public class MyCrawler extends WebCrawler {

	
	
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp3|zip|gz))$");

	 Map<String, Video> foodMap = new HashMap<String, Video>();
	 List<Video> foods = new ArrayList<Video>();
	
	  public MyCrawler() {
	
	  }


	/**
	 * if setMaxDepthOfCrawling = 0 . The shouldVisite won't invoke. It is
	 * invoked only when setMaxDepthOfCrawling > 0
	 * 
	 * @param url
	 * @return
	 */
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return isVisit(href);
	}

	private boolean isVisit(final String url) {
		boolean visit = true;

		if (!FILTERS.matcher(url).matches() && url.startsWith("https://www.youtube.com/watch?v=")) {
			return visit;
		} else {
			visit = false;
		}
		return visit;
	}

	private boolean validateURLFormatVideo(final String url) {
		boolean visit = true;
		if (!FILTERS.matcher(url).matches() && url.startsWith("/watch?v=")) {
			return visit;
		} else {
			visit = false;
		}
		return visit;
	}

	@Override
	public void visit(Page page) {
		foodMap.clear();
		String url = page.getWebURL().getURL();
		System.out.println("URL " + url);
		String channel = "";
		if (page.getParseData() instanceof HtmlParseData) {
			
			try {

				if (url.contains("channel")) {
					 channel = page.getWebURL().getURL();
					 addFoodFromChannel(page,channel);
				} else {
					addFoodFromNoneChannel(page,channel);
				}

				for (Map.Entry<String, Video> entry : foodMap.entrySet()) {
			//		System.out.println(entry.getValue());
					foods.add(entry.getValue());
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

			System.out.println("Finish Clawring");
		}

	}

	private void addFoodFromChannel(Page page,String channel) throws Exception {
		String content = new String(page.getContentData(), page.getContentCharset());
		Pattern pattern = Pattern.compile("<a[^>]*title=\"(.*)\"*href=\"([^\"]*)\"[^>]*>(.*)</a>", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			if (validateURLFormatVideo(matcher.group(2))) {
				String[] image = matcher.group(2).split("=");
				String[] name = matcher.group(1).split("\"");
				Video video = new Video();
				video.setVideo(true);
				video.setName(name[0]);
		    	video.setUrl(image[1]);
				video.setImage("//i.ytimg.com/vi/" + image[1] + "/mqdefault.jpg");
				video.setChannelURL(channel);
				foodMap.put(matcher.group(1), video);
			}
		}
	}

	private void addFoodFromNoneChannel(Page page,String channel) throws Exception {
		String content = new String(page.getContentData(), page.getContentCharset());
		Pattern pattern = Pattern.compile("<a href=\"([^\"]*)\"[^>]* title=\"(.*)\">", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			if (validateURLFormatVideo(matcher.group(1))) {
				String match = matcher.group(2);
				String[] elements = match.split("\"");
				String imageElement = matcher.group(1);
	        	String[] images = imageElement.split("=");
	        	Video video = new Video();
	        	video.setVideo(true);
				video.setName(elements[0]);
				video.setChannelURL(channel);
				video.setUrl(images[1]);
				video.setImage("//i.ytimg.com/vi/" + images[1] + "/default.jpg");
				foodMap.put(matcher.group(1), video);
			}

		}

	}
	
	/**
	   * This function is called by controller to get the local data of this crawler when job is finished
	   */
	  @Override
	  public Object getMyLocalData() {
	    return foods;
	  }

     

}
