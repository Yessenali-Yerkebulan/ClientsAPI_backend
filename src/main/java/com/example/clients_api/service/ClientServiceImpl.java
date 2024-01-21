package com.example.clients_api.service;

import com.example.clients_api.model.Client;
import com.example.clients_api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository repository;

    @Override
    public Page<Client> getClients(String firstName, int page, int size) {
        return repository.findByFirstNameContaining(firstName, PageRequest.of(page, size));
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
