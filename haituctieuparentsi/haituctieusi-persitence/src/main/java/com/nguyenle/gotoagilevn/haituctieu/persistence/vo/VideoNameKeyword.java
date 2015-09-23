package com.nguyenle.gotoagilevn.haituctieu.persistence.vo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="videokeyword")
public class VideoNameKeyword implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String displayName;
	public VideoNameKeyword() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	
	
	
}
