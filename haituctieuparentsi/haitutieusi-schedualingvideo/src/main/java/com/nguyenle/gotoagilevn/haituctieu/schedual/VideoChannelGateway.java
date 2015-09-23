package com.nguyenle.gotoagilevn.haituctieu.schedual;



import java.util.Collection;

import com.nguyenle.gotoagilevn.haituctieu.persistence.vo.VideoChannel;

public interface VideoChannelGateway {

	void getAllVideoChanelsFromDB(Collection<VideoChannel> videochannels);
}
