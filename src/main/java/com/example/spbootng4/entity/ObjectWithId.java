package com.example.spbootng4.entity;

public abstract class ObjectWithId {

  private Long id;

  public ObjectWithId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
