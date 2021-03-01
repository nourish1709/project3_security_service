package com.nourish1709.project3_security_service.entity;


import com.nourish1709.project3_security_service.entity.enums.UserAuthority;
import com.nourish1709.project3_security_service.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private String password;
    private String email;

    /*@ElementCollection(targetClass = UserAuthority.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<? extends GrantedAuthority> authorities;*/

    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities.stream().map(a -> new SimpleGrantedAuthority(a.name())).collect(Collectors.toList());
        return role.getGrantedAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
