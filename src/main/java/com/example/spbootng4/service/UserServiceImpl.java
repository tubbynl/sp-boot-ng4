package com.example.spbootng4.service;

import com.example.spbootng4.entity.User;
import com.example.spbootng4.exception.UserNotFoundException;
import com.example.spbootng4.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private User encodePassword(User user) {
      user.setPassword(passwordEncoder().encode(user.getPassword()));
      return user;
    }

    /**
     * Returns all users
     * @return List of users
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Returns user with given id
     * @param id to look for
     * @return user with given id
     * @throws UserNotFoundException if user with given id does not exists
     */
    @Override
    public User findById(Long id) {
      return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Returns user with given email
     * @param email to look for
     * @return user with given email
     * @throws UserNotFoundException if user with given email does not exists
     */
    @Override
    public User findByEmail(String email) {
      return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Returns user with given name
     * @param name to look for
     * @return name with given email
     * @throws UserNotFoundException if user with given name does not exists
     */
    @Override
    public User findByName(String name) {
      return userRepository.findByName(name).orElseThrow(UserNotFoundException::new);
    }

    /**
     * Adds or updates user.
     * If user with following id already exists it will be updated elsewhere added as the new one.
     * @param user to add or update
     * @return Added or updated user
     */
    @Override
    public User save(User user) {
      return userRepository.findById(user.getId())
        .map(this::encodePassword)
        .map(userRepository::save)
        .orElseThrow(UserNotFoundException::new);
    }

    /**
     * Deletes user by given id
     * @param id to look for
     */
    @Override
    public void delete(Long id) {
      userRepository.delete(id);
    }
}
