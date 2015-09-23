package com.nguyenle.gotoagilevn.haituctieu.persistence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.VideoChannel;

@Repository
public interface VideoChannelRepository extends MongoRepository<VideoChannel, String>  {

	
	@Query("{isActive : ?0}")
	public List<VideoChannel> findAllActiveChannel(boolean active);
	
	@Query("{channelUrl : ?0}")
	public VideoChannel getChannelByUrl(String channelUrl);
}
