package ua.malysh.api.v1;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import ua.malysh.model.Product;

import javax.validation.Valid;

import static ua.malysh.api.v1.Api.PRODUCT;

@Controller(PRODUCT)
public class ProductController {

    @Post("/add")
    @Status(HttpStatus.CREATED)
    void save(@NonNull @Valid Product product) {

    }
}
