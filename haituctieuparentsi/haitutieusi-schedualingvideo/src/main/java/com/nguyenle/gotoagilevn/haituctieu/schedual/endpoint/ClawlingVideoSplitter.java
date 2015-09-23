package com.nguyenle.gotoagilevn.haituctieu.schedual.endpoint;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Video;
import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.VideoChannel;
import com.nguyenle.gotoagilevn.haituctieu.schedual.crawler.VideoController;

@MessageEndpoint
public class ClawlingVideoSplitter {

	private final static Logger LOGGER = Logger.getLogger(ClawlingVideoSplitter.class.getName()); 
	
	@Autowired
	VideoController videoController; 
	
	@Splitter
	public List<Video> getAllVideo(VideoChannel videoChannel) {
		LOGGER.info("Base on 1 channel. Got all video belong to this channen and split each video to filter channel");
		List<Video> videos = new ArrayList<>();
		try {
		videos =	videoController.startClawringChannel(videoChannel.getChannelUrl());
		} catch (Exception e) {
			LOGGER.error(e);
		}
		

		return videos;
	}
}
