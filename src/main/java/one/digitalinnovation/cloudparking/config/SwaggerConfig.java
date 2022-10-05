package one.digitalinnovation.cloudparking.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI (){
        return new OpenAPI()
                .info(new Info()
                        .title("Parking REST API")
                        .version("1.0.0")
                        .description("Spring Boot REST API for Parking")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(myContact())
                        .license(new License().name("Apache License Version 2.0").url("http://springdoc.org")));
    }

    public Contact myContact(){
        return new Contact()
                .email("jtf.10@hotmail.com")
                .name("Jeferson Torres")
                .url("https://github.com/JefersonT");
    }
}
