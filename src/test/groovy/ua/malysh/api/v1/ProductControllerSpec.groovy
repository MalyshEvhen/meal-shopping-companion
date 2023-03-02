package ua.malysh.api.v1

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import static ua.malysh.api.v1.Api.*

@MicronautTest
class ProductControllerSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient httpClient

    void 'invalid Product return 400'() {
        given:
        BlockingHttpClient client = httpClient.toBlocking()

        when:
        client.exchange(HttpRequest.POST(PRODUCT + "/add", '{}'))

        then:
        HttpClientResponseException e = thrown()
        HttpStatus.BAD_REQUEST == e.status
        e.response.contentType.isPresent()
        'application/problem+json' == e.response.contentType.get().toString()
    }
}
