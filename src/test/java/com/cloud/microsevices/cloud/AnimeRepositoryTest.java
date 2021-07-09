package com.cloud.microsevices.cloud;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cloud.microsevices.cloud.domain.Anime;
import com.cloud.microsevices.cloud.repository.AnimeRepository;

@DataJpaTest
@DisplayName("Teste mod 1")
class AnimeRepositoryTest {
	
	static final Logger LOGGER = LoggerFactory.getLogger(AnimeRepositoryTest.class);
	
	@Autowired
	private AnimeRepository animeRepository;
	
	@Test
	@DisplayName("anime salve")
	void Salve_PersietAnime_WhenSuccessful() {
		
		Anime animeTobeSaved =  createAnime();
		Anime AnimeSaved =  this.animeRepository.save(animeTobeSaved);
		LOGGER.info("rum teste on");
		LOGGER.info(AnimeSaved.getName());
		Assertions.assertThat(AnimeSaved).isNotNull();
		Assertions.assertThat(AnimeSaved.getId()).isNotNull();
		Assertions.assertThat(AnimeSaved.getName()).isEqualTo(animeTobeSaved.getName());
		
		
	}
	
	
	private Anime createAnime() {
		Anime anime1 = new Anime();
		anime1.setName("anime teste ok ");
		return anime1;
	}
	

}
