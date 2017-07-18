package com.example.spbootng4.repository;

import com.example.spbootng4.entity.Role;
import com.example.spbootng4.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends ArrayList<User> implements UserRepository {

  public UserRepositoryImpl() {
    super(Arrays.asList(
      new User(1l,"Test user","test@tubby.nl" ,"user", Role.USER),
      new User(2l,"Test admin","admin@tubby.nl" ,"admin", Role.USER))
    );
  }

  @Override
  public User save(User instance) {
    Long id = maxId().orElse(0l)+1;
    User newInstance = new User(id,instance.getName(),instance.getEmail(),instance.getPassword(),Role.USER);
    add(newInstance);
    return newInstance;
  }

  @Override
  public Optional<User> update(User instance) {
    return findById(instance.getId()).map(persistedInstance->{
      persistedInstance.setName(instance.getName());
      return persistedInstance;
    });
  }
}
