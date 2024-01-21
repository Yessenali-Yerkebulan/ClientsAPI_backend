package com.example.clients_api.service;

import com.example.clients_api.model.Client;
import org.springframework.data.domain.Page;

public interface ClientService {
    Page<Client> getClients(String name, int page, int size);

    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(Integer id);
}
