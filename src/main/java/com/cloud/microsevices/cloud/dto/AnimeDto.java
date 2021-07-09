package com.cloud.microsevices.cloud.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.cloud.microsevices.cloud.domain.Anime;

public class AnimeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotEmpty(message = "the name cont not be empty")
	private String name;
	
	
	

	public Anime fromDTO(AnimeDto objDto) {
		return new Anime(objDto.getId(), objDto.getName());
	}
	
	
	
	public AnimeDto () {}

	public AnimeDto(Anime obj ) {
		id = obj.getId();
		name = obj.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
