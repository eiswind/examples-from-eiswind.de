package de.eiswind.restclienttest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

// tag::snip[]
@Service
public class SomeWildApiClient {

    private RestClient restClient;

    public SomeWildApiClient(
            @Value("${some-wild-api.url}") // <1> Die baseUrl muss dynamisch sein, damit wir zwischen der echten API und dem Mock umschalten können.
            String baseUrl,
            RestClient.Builder builder
    ) {
        this.restClient = builder.baseUrl(baseUrl).build();
    }

    public String invokeApi() {
        return restClient.get()
                .uri("/some-wild-api")
                .retrieve()
                .body(String.class);
    }
}
// end::snip[]