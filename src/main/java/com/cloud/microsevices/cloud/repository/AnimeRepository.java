package com.cloud.microsevices.cloud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.microsevices.cloud.domain.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long > { 
}
