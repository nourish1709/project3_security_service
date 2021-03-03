package com.nourish1709.project3_security_service.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsOfAuthenticationRequest {
    private String username;
    private String password;
}
