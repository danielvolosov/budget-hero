package com.danielvolosov.budgethero.controller;

import com.danielvolosov.budgethero.payload.request.LoginRequest;
import com.danielvolosov.budgethero.payload.response.WebResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @PostMapping("/signIn")
    @Operation(
            description = "Sign In Service",
            responses = {
                    @ApiResponse(responseCode = "400", ref = "badRequestAPI"),
                    @ApiResponse(responseCode = "500", ref = "internalServerErrorAPI"),
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully signed in!",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"status\" : \"Ok\", \"message\" : \"Successfully signed in!\"}"
                                            )
                                    }
                            )
                    )
            })

    public ResponseEntity<?> signIn(@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            mediaType = "application/json",
            examples = {
                    @ExampleObject(
                            value = "{\"username\" : \"admin\", \"password\" : \"admin\"}"
                    )
            }
    )) @RequestBody LoginRequest request) {
        return new ResponseEntity<>(
                new WebResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        "Successfully signed in!"
                ), HttpStatus.OK
        );
    }
}
