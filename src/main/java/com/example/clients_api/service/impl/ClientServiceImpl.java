package com.example.clients_api.service.impl;

import com.example.clients_api.model.Client;
import com.example.clients_api.repository.ClientRepository;
import com.example.clients_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> getClients() {
        return repository.findAll();
    }

    @Override
    public void addClient(Client client) {
        repository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        repository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        repository.deleteById(id);
    }
}
