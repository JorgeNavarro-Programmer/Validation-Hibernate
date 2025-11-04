package com.jorgenavarro.validation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jorgenavarro.validation.service.ClientService;
import com.jorgenavarro.validation.validation.ClientDoNotExistValidation;
import com.jorgenavarro.validation.validation.ClientFoundValidation;

/**
 * @author Jorge Navarro
 *         This class create the validators
 */
@Configuration
public class ConfigurationValidator {

    /**
     * Create the ClientDoNotExistValidation
     * 
     * @param clientService - clientService
     * @return ClientDoNotExistValidation
     */
    @Bean
    public ClientDoNotExistValidation getClientDoNotExistValidation(ClientService clientService) {
        return new ClientDoNotExistValidation(clientService);
    }

    /**
     * Create the ClientNotFoundValidation
     * 
     * @param clientService - clientService
     * @return ClientNotFoundValidation
     */
    @Bean
    public ClientFoundValidation getClientNotFound(ClientService clientService) {
        return new ClientFoundValidation(clientService);
    }
}
