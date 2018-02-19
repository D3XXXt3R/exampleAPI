package com.example.demo.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TheSameFollowedUserException extends Exception {


    public TheSameFollowedUserException(String message) {
        super(message);
    }

    public TheSameFollowedUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public TheSameFollowedUserException(Throwable cause) {
        super(cause);
    }

    public TheSameFollowedUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
