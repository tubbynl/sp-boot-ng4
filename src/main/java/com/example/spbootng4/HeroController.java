package com.example.spbootng4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/hero")
public class HeroController {

  private List<Hero> heroes = new ArrayList<>(Arrays.asList(
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
    new Hero(20l, "Tornado")));

  @GetMapping
  @ResponseBody
  public List<Hero> list() {
    return this.heroes;
  }

  @GetMapping("/{id}")
  @ResponseBody
  public Hero get(@PathVariable("id") Long id) {
    return this.heroes.stream().filter(h->h.getId().equals(id)).findAny().orElse(null);
  }

  @PostMapping
  public Hero create(@RequestBody Hero hero) {
    //Long id = this.heroes.stream().map(Hero::getId).max(Long::compareTo).orElse(0l)+1;
    Hero newHero = new Hero(id,hero.getName());
    this.heroes.add(newHero);
    return newHero;
  }

  @PutMapping("/{id}")
  public Hero update(@PathVariable("id") Long id,@RequestBody Hero hero) {
    get(id).setName(hero.getName());
    return get(id);
  }
}
