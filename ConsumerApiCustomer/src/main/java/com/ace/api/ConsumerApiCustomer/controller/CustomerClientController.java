package com.ace.api.ConsumerApiCustomer.controller;

import com.ace.api.ConsumerApiCustomer.payload.MensajeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Customer Client")
public class CustomerClientController {

    @Operation(summary = "Consulta por el rfc y solicita el apiKey")
    @GetMapping("/Customer/{rfc}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAllCustomer(@PathVariable String rfc, @RequestBody String apiKey){
        //buscamos el ciente
        //validamos que tengamos el cliente
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("RFC: " + rfc + " /Apikey: " + apiKey)
                .object(null).build(),HttpStatus.OK);
    }
}
