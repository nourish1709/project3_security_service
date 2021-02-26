package com.nourish1709.project3_security_service.controllers;

import com.nourish1709.project3_security_service.JwtUtill.JwtCreateToken;
import com.nourish1709.project3_security_service.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtCreateToken jwtCreateToken;
    private final AuthenticationManager authenticationManager;

    @RequestMapping(value = "/ligin", method = RequestMethod.POST)
    public ResponseEntity<String> createAuthToken(@RequestBody AuthenticationRequest auth) throws AccessDeniedException {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
        UserDetails userDetails = userService.login(auth.getUsername(), auth.getPassword());

        final String jwt = jwtCreateToken.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }

    @RequestMapping(value = "/dummy", method = RequestMethod.POST)
    public ResponseEntity<String> createAuthToken() {
        return ResponseEntity.ok("user");
    }

    @Data
    public static class AuthenticationRequest implements Serializable {
        private String username;
        private String password;
    }
}