package com.cloud.microsevices.cloud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cloud.microsevices.cloud.domain.Anime;
import com.cloud.microsevices.cloud.dto.AnimeDto;
import com.cloud.microsevices.cloud.exception.ObjectNotFoundException;
import com.cloud.microsevices.cloud.repository.AnimeRepository;

@Service
public class AnimeService {
	
	@Autowired
	private AnimeRepository animeRepository;
	
	private static  List<Anime> Animes = new ArrayList<Anime>();
	
	static {
		Anime anime1 = new Anime(1L, "item um ok");
		Anime anime2 = new Anime(2L, "anime 2");
		
		Animes.add(anime1);
		Animes.add(anime2);
	}
	
	

	public List<Anime> listAll(){
		return animeRepository.findAll();
	}
	
	public Anime findById(long id){
		return animeRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id));			
				
				/*
				 * Animes.stream()
				.filter(anime -> anime.getId().equals(id))
				.findFirst()
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "anime not found")  );
				*/
	}
	
	public Anime save(Anime anime) {
		  System.out.println("save service ok");
		  anime.setId(null);
		  return animeRepository.save(anime);
		  /*
		  anime.setId(ThreadLocalRandom.current().nextLong(3, 1000000 ));
		  Animes.add(anime);
		  return anime;
		  */
	}
	
	@Transactional
	public Anime save_transct(Anime anime) {
		  System.out.println("save_transct");
		  anime.setId(null);
		  if(true) 
			  throw new RuntimeException("bad code not save");
		  return animeRepository.save(anime);
		  /*
		  anime.setId(ThreadLocalRandom.current().nextLong(3, 1000000 ));
		  Animes.add(anime);
		  return anime;
		  */
	}
	
	public void delete(long id){
		//Animes.remove(findById(id));
		animeRepository.delete(findById(id));
	}
	
	public void replace(Anime anime){
		Anime newObj = findById(anime.getId());
		newObj.setName(anime.getName());
		animeRepository.save(newObj);
	}
	
	
}
