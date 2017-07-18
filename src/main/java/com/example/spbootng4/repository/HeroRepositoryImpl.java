package com.example.spbootng4.repository;

import com.example.spbootng4.entity.Hero;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class HeroRepositoryImpl extends ArrayList<Hero> implements HeroRepository {

  public HeroRepositoryImpl() {
    super(Arrays.asList(
      new Hero(0l, "Zero"),
      new Hero(11l, "Mr. Nice"),
      new Hero(12l, "Narco"),
      new Hero(13l, "Bombasto"),
      new Hero(14l, "Celeritas"),
      new Hero(15l, "Magneta"),
      new Hero(16l, "RubberMan"),
      new Hero(17l, "Dynama"),
      new Hero(18l, "Dr IQ"),
      new Hero(19l, "Magma"),
      new Hero(20l, "Tornado"))
    );
  }

  @Override
  public Hero save(Hero instance) {
    Long id = maxId().orElse(0l)+1;
    Hero newHero = new Hero(id,instance.getName());
    add(newHero);
    return newHero;
  }

  @Override
  public Optional<Hero> update(Hero instance) {
    return findById(instance.getId()).map(hero->{
      hero.setName(instance.getName());
      return  hero;
    });
  }
}
