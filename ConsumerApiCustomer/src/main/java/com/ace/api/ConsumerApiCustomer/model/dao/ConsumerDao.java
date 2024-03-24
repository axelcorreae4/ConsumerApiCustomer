package com.ace.api.ConsumerApiCustomer.model.dao;

import com.ace.api.ConsumerApiCustomer.component.consumerApi.ConsumerApi;
import com.ace.api.ConsumerApiCustomer.model.dto.CustomerDto;
import com.ace.api.ConsumerApiCustomer.payload.MensajeResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ConsumerDao {
    private ConsumerApi consumerApi;

    public ConsumerDao(ConsumerApi consumerApi){
        this.consumerApi = consumerApi;
    }

    public MensajeResponse findByRfc(String apiKey, String rfc){
        MensajeResponse mensajeResponse = null;
        ArrayList<CustomerDto> listClientes = new ArrayList<>();
        //Receive the Json Response
        mensajeResponse = this.consumerApi.listaClientesFake();

        //Check status
        if (mensajeResponse.getStatus() == 200){
            //find by RFC in List
            for (int i=0; i<mensajeResponse.getClientes().size();i++){
                if (mensajeResponse.getClientes().get(i).getRfc().equals(rfc)){
                    listClientes.add(mensajeResponse.getClientes().get(i));
                }
            }
            if (listClientes.isEmpty() || listClientes == null){
                mensajeResponse = new MensajeResponse("No existe ningun RFC relacionado",
                        mensajeResponse.getStatus(),
                        null);
            }
            else {
                mensajeResponse.setClientes(listClientes);
            }
        }
        else if (mensajeResponse.getStatus() == 401){
            mensajeResponse.setMensaje("Api Key Invalido");
        }
        else if(mensajeResponse.getStatus() >= 500 && mensajeResponse.getStatus() <= 599){
            mensajeResponse.setMensaje("Error interno del servidor: " + mensajeResponse.getMensaje());
        }

        return mensajeResponse;
    }
}
