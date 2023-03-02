package ua.malysh.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;

import javax.validation.constraints.NotBlank;

@Introspected
public class FridgeProduct {

    @NonNull
    @NotBlank
    private final String name;

    @NonNull
    private final Product product;

    @Nullable
    private final Double amount;

    public FridgeProduct(
            @NonNull String name,
            @NonNull Product product,
            @Nullable Double amount
    ) {
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

    @Nullable
    public Double getAmount() {
        return amount;
    }
}
