package com.jorgenavarro.validation.validation;

import com.jorgenavarro.validation.entities.Client;
import com.jorgenavarro.validation.service.ClientService;
import com.jorgenavarro.validation.validation.annotions.ClientDoNotExist;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Jorge Navarro
 *         This class valid if the client don´t exist
 */
public class ClientDoNotExistValidation implements ConstraintValidator<ClientDoNotExist, Client> {

    /**
     * Used to vilid if the client exist
     */
    private ClientService clientService;

    /**
     * Constructor the ClientDoNotExistValidation
     * 
     * @param clientService - to find the user
     */
    public ClientDoNotExistValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Comprobe if the user exist or not
     * 
     * @param value - client to valid to exist or not
     * @return true if the user don´t exist, false if the user exist
     */
    @Override
    public boolean isValid(Client value, ConstraintValidatorContext context) {
        if (clientService.findByUsername(value.getUserName()) == null) {
            return true;
        }

        return false;
    }

}
