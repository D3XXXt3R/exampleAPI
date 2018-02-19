package com.example.demo.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TooLongStringException extends Exception {

    public TooLongStringException() {
        super();
    }
    public TooLongStringException(String message, Throwable cause) {
        super(message, cause);
    }
    public TooLongStringException(String message) {
        super(message);
    }
    public TooLongStringException(Throwable cause) {
        super(cause);
    }
}
