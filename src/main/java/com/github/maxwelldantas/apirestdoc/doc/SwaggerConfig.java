package com.github.maxwelldantas.apirestdoc.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private Contact contato() {
        Contact contact = new Contact();
        contact.setName("Maxwell Dantas");
        contact.setUrl("http://maxwelldantas.com");
        contact.setEmail("maxwelldsouza@hotmail.com");
        return contact;
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .pathsToMatch("/public/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Example Spring Boot REST API")
                        .description("API exemplo de uso de Spring Boot REST API")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(this.contato()))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

}
