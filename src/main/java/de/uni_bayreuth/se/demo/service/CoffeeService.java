package de.uni_bayreuth.se.demo.service;

import de.uni_bayreuth.se.demo.model.Coffee;
import de.uni_bayreuth.se.demo.model.CoffeeNotFoundException;
import de.uni_bayreuth.se.demo.repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import de.uni_bayreuth.se.demo.model.CoffeeUpdateRequest;
import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeByName(String name) {
        return coffeeRepository.findByName(name)
                .orElseThrow(() -> new CoffeeNotFoundException("Coffee shop not found: " + name));
    }

    public List<Coffee> getAccessibleCoffees() {
        return coffeeRepository.findAccessible();
    }


    public Coffee updateCoffee(String name, CoffeeUpdateRequest updatedCoffee) {
        Coffee existing = coffeeRepository.findByName(name)
                .orElseThrow(() ->
                        new CoffeeNotFoundException("Coffee '" + name + "' not found"));
        Coffee newCoffee = new Coffee(existing.id(), updatedCoffee.name(), updatedCoffee.price(), updatedCoffee.wheelchairAccessible() );

        return coffeeRepository.replace(name,newCoffee);
    }
}
