package com.jorgenavarro.validation.validation;

import com.jorgenavarro.validation.entities.Client;
import com.jorgenavarro.validation.service.ClientService;
import com.jorgenavarro.validation.validation.annotions.ClientDoNotExist;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientDoNotExistValidation implements ConstraintValidator<ClientDoNotExist, Client> {

    private ClientService clientService;

    public ClientDoNotExistValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(Client value, ConstraintValidatorContext context) {
        if (clientService.findByUsername(value.getUserName()) == null) {
            return true;
        }

        return false;
    }

}
