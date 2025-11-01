package com.jorgenavarro.validation.validation.annotions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jorgenavarro.validation.validation.ClientNotFoundValidation;

import jakarta.validation.Constraint;


@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClientNotFoundValidation.class)
public @interface ClientNotFound {
    String message() default "We have not any client with this ID";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
