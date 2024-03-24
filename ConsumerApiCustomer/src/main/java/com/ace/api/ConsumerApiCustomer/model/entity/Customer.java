package com.ace.api.ConsumerApiCustomer.model.entity;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer implements Serializable {
    private Integer customerId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String email;
    private String rfc;
    private String alias;
}
