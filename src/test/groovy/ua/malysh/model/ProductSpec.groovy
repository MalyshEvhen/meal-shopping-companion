package ua.malysh.model

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validator

@MicronautTest(startApplication = false)
class ProductSpec extends Specification {

    @Inject
    Validator validator;

    void'no constraint violation for valid Product'() {
        given:
        def product = new Product("name", BigDecimal.ONE, Measure.KILOGRAM, Category.BAKERY)

        expect:
        validator.validate(product).isEmpty()
    }

    @Unroll('Product name with value #name is not valid')
    void'Product::name is required'(String name) {
        given:
        def product = new Product(name, BigDecimal.ONE, Measure.KILOGRAM, Category.BAKERY)

        expect:
        !validator.validate(product).isEmpty()

        where:
        name << [null, ""]
    }
}
