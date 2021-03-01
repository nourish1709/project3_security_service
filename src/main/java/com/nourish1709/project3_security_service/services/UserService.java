package com.nourish1709.project3_security_service.services;

import com.nourish1709.project3_security_service.daos.UserRepository;
import com.nourish1709.project3_security_service.entity.User;
import com.nourish1709.project3_security_service.entity.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.List;

import static com.nourish1709.project3_security_service.entity.enums.UserRole.*;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    static AccessDeniedException accessDenied = new AccessDeniedException("Access denied");

    /*public UserService(UserRepository userRepository,@Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }*/

    /*public UserDetails login(String username, String password) throws AccessDeniedException {
        var user = userRepository.findByUsername(username).orElseThrow(() -> accessDenied);
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw accessDenied;
        return user;
    }*/


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @PostConstruct
    private void addUsers() {
        List<User> users = Arrays.asList(
                new User(
                        1L,
                        "Oleg",
                        "secret",
                        "email",
                        ADMIN
                ),
                new User(
                        2L,
                        "Roman",
                        "secret",
                        "email",
                        ADMIN
                ),
                new User(
                        3L,
                        "Andriana",
                        "secret",
                        "email",
                        ADMIN
                ),
                new User(
                        4L,
                        "user",
                        "secret",
                        "email",
                        USER
                )
        );

        userRepository.saveAll(users);
    }
}
