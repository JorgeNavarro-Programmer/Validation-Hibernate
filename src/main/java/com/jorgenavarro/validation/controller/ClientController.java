package com.jorgenavarro.validation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgenavarro.validation.entities.Client;
import com.jorgenavarro.validation.service.ClientService;
import com.jorgenavarro.validation.validation.annotions.ClientDoNotExist;
import com.jorgenavarro.validation.validation.annotions.ClientNotFound;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Jorge Navarro
 *         Controller the clients gestions
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    /**
     * Save the client if client is valid
     * 
     * @param entity - client
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClient(@Valid @ClientDoNotExist @RequestBody Client entity) {

        clientService.save(entity);
    }

    /**
     * Return the client with this ID
     * 
     * @param id - client ID
     * @return Client
     */
    @GetMapping("/findUser/{id}")
    public ResponseEntity<?> findUser(@ClientNotFound @PathVariable Long id) {

        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    /**
     * Remove the client with this ID
     * 
     * @param id - client ID
     */
    @DeleteMapping("/remove/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeUser(@ClientNotFound @PathVariable Long id) {
        clientService.remove(id);
    }

    /**
     * Return a client list
     * 
     * @return Client list
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

}
