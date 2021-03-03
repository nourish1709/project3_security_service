package com.nourish1709.project3_security_service.exceptions;

public class IncorrectJwtTokenException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Token someToken cannot be trusted";

    public IncorrectJwtTokenException(String token) {
        super(ERROR_MESSAGE.replaceFirst("someToken", token));
    }
}
