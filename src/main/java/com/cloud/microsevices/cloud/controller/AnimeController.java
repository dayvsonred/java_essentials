package com.cloud.microsevices.cloud.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.microsevices.cloud.domain.Anime;
import com.cloud.microsevices.cloud.dto.AnimeDto;
import com.cloud.microsevices.cloud.service.AnimeService;

import utill.DateUtil;

@RestController
@RequestMapping("anime")
public class AnimeController {
	
	 	private DateUtil dateUtil = new DateUtil();
	 	
	 	@Autowired
	 	private AnimeService animeService;

	    @GetMapping(path = "list")
	    public ResponseEntity<List<Anime>> list(){
	    	System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
	    	
	        return ResponseEntity.ok().body(animeService.listAll());
	        		
	    }
	    
	    
	   @GetMapping(path = "/{id}")
	    public ResponseEntity <Anime> findById(@PathVariable long id){
	    	System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
	        return ResponseEntity.ok().body(animeService.findById(id));
	        		
	    }
	   
	   @PostMapping(path = "save")
	   public ResponseEntity <Anime> save(@RequestBody Anime anime){
		   System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		   System.out.println("save ok");
	    	return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
	        		
	    }
	   
	   
	   @PostMapping(path = "save_transct")
	   public ResponseEntity <Anime> save_transct(@RequestBody Anime anime){
	    	return new ResponseEntity<>(animeService.save_transct(anime), HttpStatus.CREATED);
	    }
	   
	   @DeleteMapping(path = "/{id}")
	   public ResponseEntity <Void> delete(@PathVariable long id){
		   System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		   	animeService.delete(id);
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        		
	    }
	   
	   
	   @PutMapping
	   public ResponseEntity <Void> replace(@RequestBody Anime anime){
		   System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		   	animeService.replace(anime);
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        		
	    }
	   
	   
	   @RequestMapping(value="/page", method=RequestMethod.GET)
		public ResponseEntity<Page<AnimeDto>> findPage(
				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction) {
			Page<Anime> list = animeService.findPage(page, linesPerPage, orderBy, direction);
			Page<AnimeDto> listDto = list.map(obj -> new AnimeDto(obj));  
			return ResponseEntity.ok().body(listDto);
		}
	   
	    
	    

}
