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

    private ConsumerDao consumerDao;
    final Logger log = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(ConsumerDao consumerDao) {
        this.consumerDao = consumerDao;
    }

    @Operation(summary = "Consulta por el rfc y solicita el apiKey")
    @GetMapping("/Customer/{rfc}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findByRfc(@PathVariable String rfc, @RequestBody String apiKey) throws JsonProcessingException {
        ApiKeyResponse apiKeyResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MensajeResponse mensajeResponse = null;
        log.info("Tamaño del rfc: " + rfc.length());

        //Validate input attributes
        if (rfc.isEmpty() || rfc.isBlank()) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Error: No se ingreso el rfc")
                    .status(400)
                    .clientes(null).build(), HttpStatus.BAD_REQUEST);
        } else if (apiKey.isEmpty() || apiKey.isBlank()) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Error: No se ingreso el ApiKey")
                    .status(400)
                    .clientes(null).build(), HttpStatus.BAD_REQUEST);
        } else {
            if (rfc.length() != 14){
                mensajeResponse = new MensajeResponse("La longitud del RFC es incorrecto",200,null);
            }
            else {
                apiKeyResponse = objectMapper.readValue(apiKey, ApiKeyResponse.class);
                log.warn("Error en atributos bien definidos: " + apiKeyResponse.getApiKey());

                mensajeResponse = consumerDao.findByRfc(apiKeyResponse.getApiKey(), rfc);
            }

            return new ResponseEntity<>(mensajeResponse, HttpStatus.OK);
        }
    }

}
