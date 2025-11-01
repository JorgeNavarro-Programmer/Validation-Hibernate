package com.jorgenavarro.validation.validation;

import com.jorgenavarro.validation.service.ClientService;
import com.jorgenavarro.validation.validation.annotions.ClientNotFound;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientNotFoundValidation implements ConstraintValidator<ClientNotFound, Long> {

    private ClientService clientService;

    public ClientNotFoundValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(clientService.findById(value) == null){
            return false;
        }
        return true;
    }

}
