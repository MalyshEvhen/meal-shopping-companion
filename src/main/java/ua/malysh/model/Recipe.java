package ua.malysh.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Introspected
public class Recipe {

    @NonNull
    @NotBlank
    private final String name;
    private final List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    public Recipe(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }
}
