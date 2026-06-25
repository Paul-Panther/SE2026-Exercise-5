package de.uni_bayreuth.se.demo.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CoffeeUpdateRequest(

        @NotBlank(message = "Name must not be blank")
        String name,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
        Double price,
        Boolean wheelchairAccessible
) {}