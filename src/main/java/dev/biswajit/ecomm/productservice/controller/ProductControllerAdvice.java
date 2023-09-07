package dev.biswajit.ecomm.productservice.controller;

import dev.biswajit.ecomm.productservice.exception.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import static dev.biswajit.ecomm.productservice.exception.ErrorCode.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<Mono<ErrorDto>> handleDefaultException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Mono.just(new ErrorDto(INTERNAL_SERVER_ERROR, e.getMessage())));
    }
}
