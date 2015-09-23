package com.nguyenle.gotoagilevn.haituctieu.persistence.service;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Category;

public interface VideoCategoryService {

	Category findByName(String name) throws Exception;
	Category saveCategory(Category category) throws Exception;
}
