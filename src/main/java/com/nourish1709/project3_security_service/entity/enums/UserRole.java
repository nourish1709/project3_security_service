package com.nourish1709.project3_security_service.entity.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    ADMIN(Set.of(UserAuthority.ROLE_ACCOUNT_READ, UserAuthority.ROLE_ACCOUNT_WRITE,
            UserAuthority.ROLE_CATEGORY_READ, UserAuthority.ROLE_CATEGORY_WRITE, UserAuthority.ROLE_POSITION_WRITE)),
    USER(Set.of(UserAuthority.ROLE_NOTIFICATION_WRITE, UserAuthority.ROLE_CATEGORY_READ,
    UserAuthority.ROLE_POSITION_READ));

    private final Set<UserAuthority> authorities;


    UserRole(Set<UserAuthority> authorities) {
        this.authorities = authorities;
    }

    public Set<UserAuthority> getAuthorities() {
        return authorities;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}


