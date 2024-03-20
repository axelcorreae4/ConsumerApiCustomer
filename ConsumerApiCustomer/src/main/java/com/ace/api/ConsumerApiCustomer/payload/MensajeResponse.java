package com.ace.api.ConsumerApiCustomer.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class MensajeResponse {
    private String mensaje;
    private Object object;
}
