package com.example.common;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.domain.Administrator;

public class LoginUserDetails implements UserDetails {
    private final Administrator administrator;
    private final Collection<? extends GrantedAuthority> authorities;

    public LoginUserDetails(Administrator administrator) {
        this.administrator = administrator;
        this.authorities = null;
    }

    public Administrator getAdministrator() {return administrator;}

    @Override
    public String getPassword() {return administrator.getPassword();}

    @Override
    public String getUsername() {return administrator.getName();}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() {return true;}
}
