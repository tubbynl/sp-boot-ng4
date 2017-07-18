package com.example.spbootng4;

import com.example.spbootng4.entity.Hero;
import com.example.spbootng4.repository.HeroRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hero")
public class HeroController {

  private final HeroRepository heroRepository;

  public HeroController(HeroRepository heroRepository) {
    this.heroRepository = heroRepository;
  }

  @GetMapping
  @ResponseBody
  public List<Hero> list() {
    return this.heroRepository.findAll();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public Hero get(@PathVariable("id") Long id) {
    return this.heroRepository.findById(id).orElse(null);
  }

  @PostMapping
  public Hero create(@RequestBody Hero hero) {
    return this.heroRepository.save(hero);
  }

  @PutMapping("/{id}")
  public Hero update(@PathVariable("id") Long id,@RequestBody Hero hero) {
    if(id.equals(hero.getId())) {
      this.heroRepository.update(hero);
      return hero;
    }
    return null;
  }
}
