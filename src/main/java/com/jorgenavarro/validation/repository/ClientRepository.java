package com.jorgenavarro.validation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgenavarro.validation.entities.Client;

/**
 * @author Jorge Navarro
 *         This interface is a repository of the clients
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    /**
     * Get all client with provide a username
     * 
     * @param userName - username from the client
     * @return return a client with this name
     */
    @Query("Select c from Client c where c.userName = :userName")
    public Client findByUsername(String userName);
}
