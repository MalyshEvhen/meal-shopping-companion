package ua.malysh.model

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Validator

@MicronautTest(startApplication = false)
class RecipeIngredientSpec extends Specification {

    @Inject
    Validator validator

    void'no constraint violation for valid RecipeIngredient'() {
        given:
        def recipeIngredient = new RecipeIngredient("name",
                new Product("name", BigDecimal.ONE, Measure.KILOGRAM, Category.BAKERY),
                0.5)

        expect:
        validator.validate(recipeIngredient).isEmpty()
    }

    void'must be constraint violation for invalid RecipeIngredient'() {
        given:
        def recipeIngredient = new RecipeIngredient(name, null, null)

        expect:
        !validator.validate(recipeIngredient).isEmpty()

        where:
        name << [null, ""]
    }
}
