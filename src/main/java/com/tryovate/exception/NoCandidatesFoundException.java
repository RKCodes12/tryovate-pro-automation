package com.tryovate.exception;

public class NoCandidatesFoundException extends RuntimeException{
    public NoCandidatesFoundException(String message) {
        super(message);
    }
}
