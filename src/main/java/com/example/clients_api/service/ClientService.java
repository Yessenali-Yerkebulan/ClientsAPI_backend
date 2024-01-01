package com.example.clients_api.service;

import com.example.clients_api.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    List<Client> getClients();

    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(Integer id);
}
