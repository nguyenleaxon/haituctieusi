package com.nguyenle.gotoagilevn.haituctieu.schedual.crawler;

import com.nguyenle.gotoagilevn.haituctieu.schedual.util.VideoConstrainsUtil;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class VideoConfigureSingleton {

	private static VideoConfigureSingleton instance = null;

	protected VideoConfigureSingleton() {

	}

	public static VideoConfigureSingleton getInstance() {
		if (instance == null) {
			instance = new VideoConfigureSingleton();

		}
		return instance;
	}

	private CrawlConfig createCrawlConfig() {
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(VideoConstrainsUtil.CRAWL_STORAGE_FOLDER);
		config.setMaxDepthOfCrawling(VideoConstrainsUtil.MAX_DEPTH_OF_CRAWLING);
		config.setMaxPagesToFetch(VideoConstrainsUtil.MAX_PAGES_TO_FETCH);
		config.setPolitenessDelay(VideoConstrainsUtil.POLITENESS_DEPLAY);
		config.setUserAgentString(VideoConstrainsUtil.USER_AGENT_STRING);
	//	config.setResumableCrawling(true);
		return config;
	}

	public CrawlController createCrawlController() throws Exception {
		CrawlConfig config = createCrawlConfig();
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
		return controller;
	}
}
