package com.ace.api.ConsumerApiCustomer.payload;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApiKeyResponse {
    private String apiKey;
}
