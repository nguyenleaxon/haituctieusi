package com.nguyenle.gotoagilevn.haituctieu.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenle.gotoagilevn.haituctieu.persistence.repository.VideoCategoryRepository;
import com.nguyenle.gotoagilevn.haituctieu.persistence.service.VideoCategoryService;
import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Category;

@Service
public class VideoCategoryServiceImpl implements VideoCategoryService{

	@Autowired
	private VideoCategoryRepository categoryRepository;
	
	@Override
	public Category findByName(String name) throws Exception {
			Category test = categoryRepository.findByName(name);
			return test ;
	}

	@Override
	public Category saveCategory(Category category) throws Exception {
		return categoryRepository.save(category);
	}

}
