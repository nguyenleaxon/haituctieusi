package com.nguyenle.gotoagilevn.haituctieu.persistence.service.impl;

import java.text.Normalizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenle.gotoagilevn.haituctieu.persistence.repository.VideoRepository;
import com.nguyenle.gotoagilevn.haituctieu.persistence.service.VideoService;
import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Video;

@Service
public class VideoServiceImpl implements VideoService {

	private final static Logger LOGGER = Logger.getLogger(VideoServiceImpl.class.getName());

	@Autowired
	VideoRepository videoRepositoryJPA;

	@Override
	public int saveVideoToDatabase(Video video) {

		try {
			String videoName = Normalizer.normalize(video.getName(), Normalizer.Form.NFD);
			String unicodeVideoName = videoName.replaceAll("[^\\x00-\\x7F]", ""); 
			video.setUnicodeName(unicodeVideoName);
			videoRepositoryJPA.save(video);
			LOGGER.info("YAHHHOOOO ");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}

		return 1;
	}

}
