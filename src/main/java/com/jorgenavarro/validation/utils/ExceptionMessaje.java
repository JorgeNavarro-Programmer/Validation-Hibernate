package com.jorgenavarro.validation.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Jorge Navarro
 *         This class return a error mensaje
 */
@Component
public class ExceptionMessaje {

    /**
     * Key from error
     */
    private final String MENSSAJE = "Error_Messaje";

    /**
     * Give a map with key value from error
     * 
     * @param error - details from error
     * @return a map with information from error
     */
    public Map<String, String> getMessage(String error) {
        Map<String, String> map = new HashMap<>();

        map.put(MENSSAJE, error);

        return map;

    }
}
