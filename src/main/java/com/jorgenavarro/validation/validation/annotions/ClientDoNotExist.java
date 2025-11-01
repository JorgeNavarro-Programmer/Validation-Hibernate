package com.jorgenavarro.validation.validation.annotions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jorgenavarro.validation.validation.ClientDoNotExistValidation;

import jakarta.validation.Constraint;

@Documented
@Target(ElementType.PARAMETER) // Where the annotation are used
@Retention(RetentionPolicy.RUNTIME) // The type of retention
@Constraint(validatedBy = { ClientDoNotExistValidation.class }) // To indicate the class is used to validate
public @interface ClientDoNotExist {
    String message() default "Client already exists"; // The mensaje who will be return when the program throw exception
                                                      // for validation

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
