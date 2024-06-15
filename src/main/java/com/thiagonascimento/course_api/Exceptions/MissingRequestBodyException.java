package com.thiagonascimento.course_api.Exceptions;

public class MissingRequestBodyException extends RuntimeException {
    public MissingRequestBodyException() {
        super("Body is missing in the request");
    }
}
