package com.mdambro.demo.infrastructure.rest.exception.handler;

import com.mdambro.demo.infrastructure.rest.dto.ErrorDTO;
import com.mdambro.validations.exception.BusinessRuleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({BusinessRuleException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDTO> badRequestExceptionHandler(Exception exception, WebRequest webRequest) {

        var errorResponse =
                ErrorDTO.builder()
                        .message(exception.getMessage())
                        .build();

        return ResponseEntity.badRequest().body(errorResponse);

    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDTO> internalServerErrorExceptionHandler(Exception exception, WebRequest webRequest) {

        var errorResponse =
                ErrorDTO.builder()
                        .message(exception.getMessage())
                        .build();

        return ResponseEntity.internalServerError().body(errorResponse);

    }

}
