package com.jorgenavarro.validation.validation;

import com.jorgenavarro.validation.service.ClientService;
import com.jorgenavarro.validation.validation.annotions.ClientNotFound;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Jorge Navarro
 *         This class valid if the client exist
 */
public class ClientNotFoundValidation implements ConstraintValidator<ClientNotFound, Long> {

    /**
     * Used to find the user
     */
    private ClientService clientService;

    /**
     * Constructor the ClientNotFoundValidation
     * 
     * @param clientService - to find the user
     */
    public ClientNotFoundValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * This method valid the input id
     * 
     * @param value - Client id
     * @return true if the client is found - false if the client is not found
     */
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (clientService.findById(value) == null) {
            return false;
        }
        return true;
    }

}
