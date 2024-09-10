package com.mdambro.demo.infrastructure.rest.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springdoc.core.customizers.ServerBaseUrlCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "springdoc.info")
@AllArgsConstructor
@NoArgsConstructor
public class SpringDocConfig {

    private String nameContact;
    private String mailContact;
    private String urlContact;
    private String title;
    private String description;
    private String version;
    @Value("${springdoc.info.enabled-server-https}")
    private boolean enabledServerHttps;

    @Bean
    public ServerBaseUrlCustomizer getServerBaseUrlCustomizer() {

        if(enabledServerHttps)
            return x -> x.replace("http", "https");

        return serverBaseUrl -> serverBaseUrl;

    }

    @Bean
    public OpenAPI getCustomOpenApi() {

        return new OpenAPI()
                .info(
                    new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .contact(
                            new Contact()
                                .name(nameContact)
                                .email(mailContact)
                                .url(urlContact)
                        )
                );

    }

}
