package com.nguyenle.gotoagilevn.haituctieu.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenle.gotoagilevn.haituctieu.persistence.repository.VideoChannelRepository;
import com.nguyenle.gotoagilevn.haituctieu.persistence.service.VideoChannelService;
import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.VideoChannel;

@Service
public class VideoChannelServiceImpl implements VideoChannelService {

	@Autowired
	VideoChannelRepository channelRepository;
	
	@Override
	public List<VideoChannel> getAllActiveChannel() throws Exception {
		return channelRepository.findAllActiveChannel(true);
	}

	@Override
	public VideoChannel getChannelByUrl(String channelUrl) throws Exception {
		VideoChannel channel =channelRepository.getChannelByUrl(channelUrl);
		return channel;
	}

}
