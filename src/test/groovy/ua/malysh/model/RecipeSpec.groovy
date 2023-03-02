package ua.malysh.model

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Validator

@MicronautTest(startApplication = false)
class RecipeSpec extends Specification {

    @Inject
    Validator validator

    void'no constraint violation for valid Recipe'() {
        given:
        def recipe = new Recipe(name)

        expect:
        validator.validate(recipe).isEmpty()

        where:
        name << ["name", "some name"]
    }

    void'constraint violation is expected for invalid Recipe name'() {
        given:
        def recipe = new Recipe(name)

        expect:
        !validator.validate(recipe).isEmpty()

        where:
        name << ["", null]
    }
}
