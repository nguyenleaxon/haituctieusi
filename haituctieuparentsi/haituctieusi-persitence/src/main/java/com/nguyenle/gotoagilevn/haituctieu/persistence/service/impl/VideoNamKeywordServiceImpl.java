package com.nguyenle.gotoagilevn.haituctieu.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenle.gotoagilevn.haituctieu.persistence.repository.VideoNameKeywordRepository;
import com.nguyenle.gotoagilevn.haituctieu.persistence.service.VideoNameKeywordService;
import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.VideoNameKeyword;

@Service
public class VideoNamKeywordServiceImpl implements VideoNameKeywordService{

	@Autowired
	VideoNameKeywordRepository keywordService;
	
	@Override
	public List<VideoNameKeyword> listAllKeywords() {
		return keywordService.findAll();
	}

	@Override
	public VideoNameKeyword findVideoNameKeyByName(String name)
			throws Exception {
		return keywordService.findVideoNameKeyByName(name);
	}

}
