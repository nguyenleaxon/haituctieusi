package com.nguyenle.gotoagilevn.haituctieu.persistence.service;

import java.util.List;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.VideoNameKeyword;

public interface VideoNameKeywordService {

	List<VideoNameKeyword> listAllKeywords();
	VideoNameKeyword findVideoNameKeyByName(String name) throws Exception;
}
