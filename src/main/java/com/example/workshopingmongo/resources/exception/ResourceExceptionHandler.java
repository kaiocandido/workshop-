package com.example.workshopingmongo.resources.exception;

import com.example.workshopingmongo.services.execption.ObjectNotFoundExcepion;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExcepion.class)
    public ResponseEntity<StanderdError> objectNotFound(ObjectNotFoundExcepion e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StanderdError err = new StanderdError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
