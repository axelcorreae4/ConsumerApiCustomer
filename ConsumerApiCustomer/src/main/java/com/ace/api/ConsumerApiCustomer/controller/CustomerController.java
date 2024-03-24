package com.ace.api.ConsumerApiCustomer.controller;

import com.ace.api.ConsumerApiCustomer.model.dao.ConsumerDao;
import com.ace.api.ConsumerApiCustomer.model.dto.CustomerDto;
import com.ace.api.ConsumerApiCustomer.payload.ApiKeyResponse;
import com.ace.api.ConsumerApiCustomer.payload.MensajeResponse;
import com.ace.api.ConsumerApiCustomer.component.consumerApi.ConsumerApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Customer Client")
public class CustomerController {

    private ConsumerApi consumerApi;
    private ConsumerDao consumerDao;
    final Logger log = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(ConsumerApi consumerApi, ConsumerDao consumerDao){

        this.consumerApi = consumerApi;
        this.consumerDao = consumerDao;
    }

    @Operation(summary = "Consulta por el rfc y solicita el apiKey")
    @GetMapping("/Customer/{rfc}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAllCustomer(@PathVariable String rfc, @RequestBody String apiKey) throws JsonProcessingException {

        //Validate input attributes
        if ()
        ApiKeyResponse apiKeyResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        apiKeyResponse = objectMapper.readValue(apiKey, ApiKeyResponse.class);
        log.warn("ApiKey: " + apiKeyResponse.getApiKey());

        //buscamos el ciente
        //validamos que tengamos el cliente
        ArrayList<CustomerDto> cliente = this.consumerApi.listaClientesFake(apiKeyResponse.getApiKey());
        log.info("Cliente en controller: " + cliente.get(0).toString());
        this.consumerApi.listaClientesFake(apiKeyResponse.getApiKey());
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Susscess")
                .clientes(cliente).build(),HttpStatus.OK);
    }

}
