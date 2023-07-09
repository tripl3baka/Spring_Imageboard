package com.example.imageboard.service;

import com.example.imageboard.model.LoginCredentials;
import com.example.imageboard.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    List<GrantedAuthority> authorityList;

    @Override
    public UserDetails loadUserByUsername(String username) {
        LoginCredentials admin = loginRepository.findByName("admin");
        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        System.out.println("xdddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        return admin;
    }
}



