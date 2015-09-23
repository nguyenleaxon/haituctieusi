package com.nguyenle.gotoagilevn.haituctieu.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.Category;

@Repository
public interface VideoCategoryRepository extends MongoRepository<Category,String> {

	@Query("{name : ?0}")
	Category findByName(String name);
	
	@Override
	public <S extends Category> S save(S arg0);
}
