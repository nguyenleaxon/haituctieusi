package com.nguyenle.gotoagilevn.haituctieu.persistence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.VideoNameKeyword;

@Repository
public interface VideoNameKeywordRepository extends MongoRepository<VideoNameKeyword, String> {

    @Override
    public List<VideoNameKeyword> findAll();
    
    @Query("{name : ?0}")
	VideoNameKeyword findVideoNameKeyByName(String name);
}
