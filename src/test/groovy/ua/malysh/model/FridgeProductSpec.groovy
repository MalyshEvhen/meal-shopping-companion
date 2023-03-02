package ua.malysh.model

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import jakarta.inject.Inject
import spock.lang.Unroll

import javax.validation.Validator

@MicronautTest(startApplication = false)
class FridgeProductSpec extends Specification {

    @Inject
    Validator validator

    void 'no constraint violation for valid FridgeProduct'() {
        given:
        def product = new FridgeProduct("name",
                new Product("name", BigDecimal.ONE, Measure.KILOGRAM, Category.BAKERY),
                null)

        expect:
        validator.validate(product).isEmpty()
    }

    @Unroll('FridgeProduct name with value #name is not valid')
    void 'FridgeProduct::name is required'(String name) {
        given:
        def product = new FridgeProduct(name,
                new Product("name", BigDecimal.ONE, Measure.KILOGRAM, Category.BAKERY),
                null)

        expect:
        !validator.validate(product).isEmpty()

        where:
        name << [null, ""]
    }
}
