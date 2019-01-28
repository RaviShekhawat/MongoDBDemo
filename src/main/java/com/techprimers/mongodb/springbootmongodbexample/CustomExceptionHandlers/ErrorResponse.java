package com.techprimers.mongodb.springbootmongodbexample.CustomExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

class ErrorResponse
{
    ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }
    //Getter and setters
}
