package com.example.clients_api.controller;

import com.example.clients_api.model.Client;
import com.example.clients_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/clients")
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }

    @PutMapping("/clients/{id}/edit")
    public void updateClient(@PathVariable("id") Integer id, @RequestBody Client client){
        clientService.updateClient(client);
    }

    @DeleteMapping("/clients/{id}/delete")
    public void deleteClient(@PathVariable("id") Integer id){
        clientService.deleteClient(id);
    }
}
