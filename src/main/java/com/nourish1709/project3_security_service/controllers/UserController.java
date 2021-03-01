package com.nourish1709.project3_security_service.controllers;

import com.nourish1709.project3_security_service.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/test")
    public ResponseEntity<List<String>> afterLogin() {
        List<String> list = Arrays.asList("Oleg", "Andriana", "Zhenya", "Roman");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
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

    @GetMapping("/afterLogin")
    public List<String> afterLogin() {
        return Arrays.asList("Hello", "Andriana", "Zhenya", "Roman");
    }*/
}