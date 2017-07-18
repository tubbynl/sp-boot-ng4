package com.example.spbootng4.repository;

import com.example.spbootng4.entity.User;

import java.util.Optional;

public interface UserRepository extends Repository<User> {

    default Optional<User> findByEmail(String email) {
      return findAny(u->u.getEmail().equalsIgnoreCase(email));
    }

    default Optional<User> findByName(String name){
      return findAny(u->u.getName().equalsIgnoreCase(name));
    }
}
