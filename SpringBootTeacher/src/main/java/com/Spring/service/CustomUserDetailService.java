package com.Spring.service;

import com.Spring.model.Role;
import com.Spring.model.User;
import com.Spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("NMT correct email or password bari");
        }

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        Collection<?extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return mapRoles;
    }
}
