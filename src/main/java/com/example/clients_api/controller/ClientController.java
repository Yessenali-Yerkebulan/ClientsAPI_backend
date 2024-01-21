package com.example.clients_api.controller;

import com.example.clients_api.model.Client;
import com.example.clients_api.model.HttpResponse;
import com.example.clients_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<HttpResponse> getClients(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size
    ){
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                .timeStamp(now().toString())
                .data(Map.of("page", clientService.getClients(name.orElse(""), page.orElse(0), size.orElse(10))))
                .message("Clients Retrieved")
                .status(OK)
                .statusCode(OK.value())
                .build());
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
