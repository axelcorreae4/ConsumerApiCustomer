package com.ace.api.ConsumerApiCustomer.model.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CustomerDto implements Serializable {
    private int customer_id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String fecha_nacimiento;
    private String email;
    private String address;
    private String rfc;
    private String alias;
}
