package com.abdul.Employeemanagementsystemgraphql.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String notFoundException){
        super(notFoundException);
    }
}
