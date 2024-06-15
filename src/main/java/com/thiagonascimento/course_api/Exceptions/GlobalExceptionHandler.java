package com.thiagonascimento.course_api.Exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MissingRequestBodyException.class)
    public ResponseEntity<Object> handleMissingRequestBodyException(MissingRequestBodyException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ErrorMessageDTO> dto = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach(error -> {
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(message, fieldName);
                dto.add(errorMessageDTO);
            } else {
                ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(message, error.getObjectName());
                dto.add(errorMessageDTO);
            }
        });

        return ResponseEntity.badRequest().body(dto);
    }
}
