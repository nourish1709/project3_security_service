package com.nourish1709.project3_security_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/test")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<String>> afterLogin() {
        List<String> list = Arrays.asList("Oleg", "Andriana", "Zhenya", "Roman");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}