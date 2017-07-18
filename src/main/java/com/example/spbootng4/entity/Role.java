package com.example.spbootng4.entity;

public class Role extends ObjectWithId {
    public static final Role USER = new Role(1l,"ROLE_USER");
    public static final Role ADMIN = new Role(2l,"ROLE_ADMIN");

    private String label;

    private Role(Long id,String label) {
      super(id);
      this.label = label;
    }

    public String getLabel() {
    return label;
  }
    public void setLabel(String label) {
    this.label = label;
  }
}
