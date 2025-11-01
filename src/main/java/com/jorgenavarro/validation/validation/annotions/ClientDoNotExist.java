package com.jorgenavarro.validation.validation.annotions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jorgenavarro.validation.validation.ClientDoNotExistValidation;

import jakarta.validation.Constraint;

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ClientDoNotExistValidation.class})
public @interface ClientDoNotExist {
    String message() default "Client already exists";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
