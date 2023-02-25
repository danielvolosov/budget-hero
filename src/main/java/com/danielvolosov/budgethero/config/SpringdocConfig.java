package com.danielvolosov.budgethero.config;

import com.danielvolosov.budgethero.utility.ReadJsonFileToJsonObject;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.io.IOException;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {

    @Bean
    public OpenAPI baseOpenAPI() throws IOException {

        ReadJsonFileToJsonObject readJsonFileToJsonObject = new ReadJsonFileToJsonObject();

        var badRequestAPI = new io.swagger.v3.oas.models.responses.ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example()
                                        .value(readJsonFileToJsonObject.read().get("badRequestResponse").toString())))
        ).description("Bad Request!");

        var internalServerErrorAPI = new io.swagger.v3.oas.models.responses.ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example()
                                        .value(readJsonFileToJsonObject.read().get("internalServerErrorResponse").toString())))
        ).description("Internal Server Error!");

        Components components = new Components();
        components.addResponses("badRequestAPI", badRequestAPI);
        components.addResponses("internalServerErrorAPI", internalServerErrorAPI);

        return new OpenAPI()
                .components(components)
                .info(new Info()
                .title("Spring Documentation")
                .version("1.0.0")
                .description("Spring Documentation"));
    }

    @Bean
    public GroupedOpenApi authenticationApi() {
        String[] paths = {"/auth/**"};

        return GroupedOpenApi.builder()
                .group("Authentication")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi expenseApi() {
        String[] paths = {"/expense/**"};

        return GroupedOpenApi.builder()
                .group("Debit")
                .pathsToMatch(paths)
                .build();
    }
}
