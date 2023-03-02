package ua.malysh.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Introspected
public class Product {

    @NonNull
    @NotBlank
    private final String name;

    @NonNull
    private final BigDecimal price;

    @NonNull
    private final Measure measure;

    @NonNull
    private final Category category;

    public Product(@NonNull String name, @NonNull BigDecimal price, @NonNull Measure measure, @NonNull Category category) {
        this.name = name;
        this.price = price;
        this.measure = measure;
        this.category = category;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public BigDecimal getPrice() {
        return price;
    }

    @NonNull
    public Measure getMeasure() {
        return measure;
    }

    @NonNull
    public Category getCategory() {
        return category;
    }
}