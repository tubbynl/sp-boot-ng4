package com.example.spbootng4.service;

import com.example.spbootng4.entity.User;
import com.example.spbootng4.repository.UserRepository;
import com.example.spbootng4.security.auth.JwtUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author saka7
 * JwtUserDetailsServiceImp is used to find UserDetails by name
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public JwtUserDetailsServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
    }

    /**
     * Finds UserDetails by given username
     * @param username which is used to search user
     * @return UserDetails
     * @throws UsernameNotFoundException if user with given name does not exists
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username)
          .map(JwtUserDetailsServiceImpl::create)
          .orElseThrow(()->new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
    }

  private static JwtUser create(User user) {
    return new JwtUser(
      user.getId(),
      user.getName(),
      user.getEmail(),
      user.getPassword(),
      new SimpleGrantedAuthority(user.getRole().getLabel())
    );
  }
}
