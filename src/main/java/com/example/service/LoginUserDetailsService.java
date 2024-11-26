package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.common.LoginUserDetails;
import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    HttpSession session;
    private AdministratorRepository administratorRepository;
    
    public LoginUserDetailsService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public LoginUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByMailAddress(email);
        if (administrator == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
        }
        session.setAttribute("administratorName", administrator.getName());
        return new LoginUserDetails(administrator);
    }
}
