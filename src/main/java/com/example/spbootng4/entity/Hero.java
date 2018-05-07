package com.example.spbootng4.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Hero extends ObjectWithId {
  private String name;

  @JsonCreator
  public Hero(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
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
