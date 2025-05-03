package com.tracklink.www.security;

import com.tracklink.www.exception.NotFoundException;
import com.tracklink.www.repository.UserRepository;
import com.tracklink.www.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByEmail(username).orElseThrow(() -> new NotFoundException("User not found!!!"));
        return new CustomUserDetails(user);
    }
}
