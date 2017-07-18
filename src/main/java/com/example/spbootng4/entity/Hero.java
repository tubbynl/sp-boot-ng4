package com.example.spbootng4.entity;

import java.time.LocalDateTime;

public class Hero extends ObjectWithId {
  private String name;

  public Hero(Long id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
