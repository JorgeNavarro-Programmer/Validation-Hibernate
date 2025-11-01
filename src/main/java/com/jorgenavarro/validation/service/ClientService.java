package com.jorgenavarro.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgenavarro.validation.entities.Client;
import com.jorgenavarro.validation.repository.ClientRepository;

/**
 * @author Jorge Navarro
 * Controller the gestions of the repository
 */
@Service
public class ClientService{
    
    /*
     * client repository
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * Find a client with id
     * @param id - client id 
     * @return a client with this id
     */
    public Client findById(long id){
        return clientRepository.findById(id).orElse(null);
    }
    
    /**
     * Save the client to database
     * @param client - client who to be added
     */
    public void save(Client client){
        clientRepository.save(client);
    }

    /**
     * Find a client with username
     * @param username - client name
     * @return client with this username
     */
    public Client findByUsername(String username){
        return clientRepository.findByUsername(username);
    }

    /**
     * Remove client with this id
     * @param id - client id
     */
    public void remove(Long id){
        clientRepository.deleteById(id);
    }

    /**
     * Return a list with all clients
     * @return all clients
     */
    public List<Client> findAll(){
        return (List<Client>) clientRepository.findAll();
    }

}
