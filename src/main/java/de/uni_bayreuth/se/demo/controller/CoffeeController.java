package de.uni_bayreuth.se.demo.controller;

import de.uni_bayreuth.se.demo.model.Coffee;
import de.uni_bayreuth.se.demo.model.CoffeeUpdateRequest;
import de.uni_bayreuth.se.demo.service.CoffeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<Coffee> getAllCoffees() {
        return coffeeService.getAllCoffees();
    }

    @GetMapping("/{name}")
    public Coffee getCoffeeByName(@PathVariable String name) {
        return coffeeService.getCoffeeByName(name);
    }

    @GetMapping("/accessible")
    public List<Coffee> getAccessibleCoffees() {
        return coffeeService.getAccessibleCoffees();
    }

    @PutMapping("/{name}")
    public  Coffee updateCoffee(@PathVariable String name, @RequestBody @Valid CoffeeUpdateRequest updatedCoffee) {
        return coffeeService.updateCoffee(name,updatedCoffee);
    }
}
