package com.abdul.Employeemanagementsystemgraphql.exception;

import graphql.GraphQLError;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GraphQlExceptionHandler {

    @org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler
    public GraphQLError handleNotFoundException(NotFoundException e) {
        return GraphQLError.newError()
                .message(e.getMessage())
                .build();
    }
}
