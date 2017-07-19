package com.example.spbootng4.service;


import com.example.spbootng4.entity.User;

import java.util.List;

public interface UserService {
  User save(User user);
  void delete(Long id);
  List<User> findAll();
  User findById(Long id);
  User findByEmail(String email);
  User findByName(String name);
}
