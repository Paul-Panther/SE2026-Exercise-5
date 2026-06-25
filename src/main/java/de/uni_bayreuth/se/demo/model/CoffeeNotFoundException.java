package de.uni_bayreuth.se.demo.model;

public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(String message) {
        super(message);
    }
}