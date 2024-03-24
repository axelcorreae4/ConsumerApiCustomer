package com.ace.api.ConsumerApiCustomer.payload;

import com.ace.api.ConsumerApiCustomer.model.dto.CustomerDto;
import com.ace.api.ConsumerApiCustomer.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@Builder
@ToString
public class MensajeResponse implements Serializable {
    private String mensaje;
    private ArrayList<CustomerDto> clientes;
}
