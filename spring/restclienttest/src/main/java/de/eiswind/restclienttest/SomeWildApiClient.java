package de.eiswind.restclienttest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SomeWildApiClient {

    private RestClient restClient;

    public SomeWildApiClient(
            @Value("${some-wild-api.url}") String baseUrl,
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
