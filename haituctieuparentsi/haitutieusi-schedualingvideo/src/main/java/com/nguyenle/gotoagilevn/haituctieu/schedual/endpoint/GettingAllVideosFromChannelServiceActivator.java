package com.nguyenle.gotoagilevn.haituctieu.schedual.endpoint;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Video;

@MessageEndpoint
public class GettingAllVideosFromChannelServiceActivator {

	private final static Logger LOGGER = Logger.getLogger(GettingAllVideosFromChannelServiceActivator.class.getName());
	
	@ServiceActivator
	public List<Video> getAllVideosFromChannel(List<Video> videos) {
		LOGGER.info("##########3 Get ALL Video From SI ############");
		return videos;
		
	}
}
