package com.nguyenle.gotoagilevn.haituctieu.schedual.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlController;





import java.util.List;

import org.springframework.stereotype.Component;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Video;
import com.nguyenle.gotoagilevn.haituctieu.schedual.util.VideoConstrainsUtil;

@Component
public class VideoController {

	private VideoConfigureSingleton videoConfig = VideoConfigureSingleton
			.getInstance();

	public List<Video> startClawringChannel(String channel) throws Exception {
		List<Video> listVideo = null;
		CrawlController controller = videoConfig.createCrawlController();
		controller.addSeed(channel);
		controller.start(MyCrawler.class, VideoConstrainsUtil.NUMBER_OF_CRAWLER);
		List<Object> crawlersLocalData = controller.getCrawlersLocalData();
		listVideo = (List<Video>) crawlersLocalData.get(0);
		if (controller.isFinished()) {
			System.out.println("Get all videos");
		}
		return listVideo;
	}

}
