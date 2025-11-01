package com.jorgenavarro.validation.validation;

import com.jorgenavarro.validation.service.ClientService;
import com.jorgenavarro.validation.validation.annotions.ClientFound;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Jorge Navarro
 *         This class valid if the client exist
 */
// This class must implement ConstraintValidator<@inteface that you created, the
// value that will be validated>
public class ClientFoundValidation implements ConstraintValidator<ClientFound, Long> {

    /**
     * Used to valid if the client exist
     */
    private ClientService clientService;

    /**
     * Constructor the ClientNotFoundValidation
     * 
     * @param clientService - to find the user
     */
    public ClientFoundValidation(ClientService clientService) {
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
