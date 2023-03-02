package ua.malysh.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;

@Introspected
public class RecipeIngredient {

    @NonNull
    @NotBlank
    private final String name;

    @NonNull
    private final Product product;

    @NonNull
    private final Double amount;

    public RecipeIngredient(@NonNull String name, @NonNull Product product, @NonNull Double amount) {
        this.name = name;
        this.product = product;
        this.amount = amount;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Product getProduct() {
        return product;
    }

    @NonNull
    public Double getAmount() {
        return amount;
    }
}
