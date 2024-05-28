package com.example.crudgame.repository;

import com.example.crudgame.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {
}
