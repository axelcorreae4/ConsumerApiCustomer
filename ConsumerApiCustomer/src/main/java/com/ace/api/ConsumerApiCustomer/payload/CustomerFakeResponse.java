package com.ace.api.ConsumerApiCustomer.payload;

import com.ace.api.ConsumerApiCustomer.model.entity.Customer;
import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerFakeResponse {
    private ArrayList<Customer> listaClientes;
}
