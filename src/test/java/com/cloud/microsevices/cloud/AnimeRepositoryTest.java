package com.cloud.microsevices.cloud;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import com.cloud.microsevices.cloud.domain.Anime;
import com.cloud.microsevices.cloud.repository.AnimeRepository;

@DataJpaTest
@DisplayName("Teste mod 1")
class AnimeRepositoryTest {
	
	//@Autowired
	@Qualifier(value = "testRestTemplateRoleAdmin")
	private TestRestTemplate testRestTemplateRoleAdmin;
	
	static final Logger LOGGER = LoggerFactory.getLogger(AnimeRepositoryTest.class);
	
	@Autowired
	private AnimeRepository animeRepository;
	
	//@LocalServerPort
	//private int port;
	
	@TestConfiguration
	@Lazy
	static class Config{
		@Bean(name =  "testRestTemplateRoleAdmin")
		public TestRestTemplate testRestTemplateteRoleUserCreator(@Value("${local.server.port}") int port) {
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
					.rootUri("http://localhost:"+port)
					.basicAuthentication("dayvson", "essentials");
			return new TestRestTemplate(restTemplateBuilder);
		}
	}
	
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
		anime1.setName("anime teste ok 123123s ");
		return anime1;
	}
	
	
	/*@Test
    @DisplayName("listAll returns list of anime when successful")
    void listAll_ReturnsListOfAnimes_WhenSuccessful() {
		Anime animeTobeSaved =  createAnime();
        Anime savedAnime = animeRepository.save(animeTobeSaved); 

        String expectedName = savedAnime.getName();

        List<Anime> animes = testRestTemplateRoleAdmin.exchange("/anime/list", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Anime>>() {
                }).getBody();
        
        LOGGER.info("anime rest http " + animes.size());

        Assertions.assertThat(animes)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
    }*/
	

}
