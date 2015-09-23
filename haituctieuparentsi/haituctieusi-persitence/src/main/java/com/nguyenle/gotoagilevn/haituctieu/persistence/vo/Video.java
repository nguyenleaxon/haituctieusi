package com.nguyenle.gotoagilevn.haituctieu.persistence.vo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "video")
public class Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String image;
	private String url;
	private String unicodeName;
    private String channelURL;

	@DBRef
	private VideoChannel channel;

	private String shortcut;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public VideoChannel getChannel() {
		return channel;
	}

	public void setChannel(VideoChannel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {

		return name;
	}

	public String getUnicodeName() {
		return unicodeName;
	}

	public void setUnicodeName(String unicodeName) {
		this.unicodeName = unicodeName;
	}

	public String getChannelURL() {
		return channelURL;
	}

	public void setChannelURL(String channelURL) {
		this.channelURL = channelURL;
	}

}
