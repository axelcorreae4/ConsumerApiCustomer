package com.ace.api.ConsumerApiCustomer.component.consumerApi;

import com.ace.api.ConsumerApiCustomer.model.dto.CustomerDto;
import com.ace.api.ConsumerApiCustomer.model.entity.Customer;
import com.ace.api.ConsumerApiCustomer.payload.ApiKeyResponse;
import com.ace.api.ConsumerApiCustomer.payload.CustomerFakeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

@Component
public class ConsumerApi implements Serializable {

    private final String urlFakeApi;
    private final Logger log = LoggerFactory.getLogger(ConsumerApi.class);
    private OkHttpClient client = new OkHttpClient();

    public ConsumerApi(String urlFakeApi){
        this.urlFakeApi = urlFakeApi;
    }

    public ArrayList<CustomerDto> listaClientesFake(String apiKey){
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<CustomerDto> clientes = null;


        String url = urlFakeApi + "?key=" + apiKey;
        Request request = new Request.Builder()
                .url(url)
                .build();
        log.info("End pooint final: " + url);
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                Type listType = new TypeToken<ArrayList<CustomerDto>>() {}.getType();
                clientes = new Gson().fromJson(responseBody, listType);

                log.info("Response Fake API: " + response.code());
            } else {
                log.error("url: " + url);
                log.error("Error en la solicitud: " + response.code());

                //log.error("Error en la solicitud: " + response.body());
            }
        } catch (Exception e) {
            log.error("Error: ", e);
        }
        return clientes;
    }
}
