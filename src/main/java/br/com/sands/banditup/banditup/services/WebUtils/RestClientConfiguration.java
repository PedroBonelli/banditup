package br.com.sands.banditup.banditup.services.WebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestClient baseRestClient(UriBuilder defaultUriBuilder){
        URI baseURI = defaultUriBuilder.host("https://accounts.spotify.com")
                .path("api")
                .build();
        return RestClient.builder().baseUrl(baseURI).build();
    }



}
