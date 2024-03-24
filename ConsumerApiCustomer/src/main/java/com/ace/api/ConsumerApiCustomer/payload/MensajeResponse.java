package com.ace.api.ConsumerApiCustomer.payload;

import com.ace.api.ConsumerApiCustomer.model.dto.CustomerDto;
import com.ace.api.ConsumerApiCustomer.model.entity.Customer;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MensajeResponse implements Serializable {
    private String mensaje;
    private Integer status;
    private ArrayList<CustomerDto> clientes;

}
