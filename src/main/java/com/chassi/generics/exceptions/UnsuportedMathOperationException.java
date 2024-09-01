package com.chassi.generics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class UnsuportedMathOperationException extends Exception{

    public UnsuportedMathOperationException(String message) {
        super(message);
    }

}
