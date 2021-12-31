package com.example.criandoapidozero.exception;

import com.example.criandoapidozero.core.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            BusinessException.class,
            ModelNotFoundException.class,
            DuplicateKeyException.class
    })
    private ResponseEntity<ErrorResponse> buildBusinessException(Exception ex, WebRequest request) {
        HttpStatus statusCode = ex instanceof ModelNotFoundException ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST;

        ErrorResponse error = new ErrorResponse();
        error.setError(ex.getMessage());
        error.setStatus(statusCode.value());
        log.error("error", ex);

        return new ResponseEntity<>(error, statusCode);
    }
}
