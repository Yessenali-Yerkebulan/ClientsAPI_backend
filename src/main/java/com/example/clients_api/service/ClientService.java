package com.example.clients_api.service;

import com.example.clients_api.model.Client;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {
    Page<Client> getClients(String name, int page, int size);

    List<Client> getAllClients();

    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(Integer id);
}
