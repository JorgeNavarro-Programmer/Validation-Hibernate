package com.jorgenavarro.validation.exceptionController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

/**
 * @author Jorge Navarro
 *         Controller the HandlerMethodValidationException when any object is
 *         not valid
 */
@RestControllerAdvice
public class ValidationExceptionController {

    /**
     * When the HandlerMethodValidationException exception is caught, information is
     * provided about why the object is invalid.
     * 
     * @param ex - The exception
     * @return a map with the information of the problem
     */
    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(HandlerMethodValidationException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getParameterValidationResults().forEach(result -> {
            String paramName = result.getMethodParameter().getParameterName();

            result.getResolvableErrors().forEach(error -> {
                String message = error.getDefaultMessage();
                errors.put(paramName, message);
            });
        });

        return errors;
    }
}
