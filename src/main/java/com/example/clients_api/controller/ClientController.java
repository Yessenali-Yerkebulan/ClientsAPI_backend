package com.example.clients_api.controller;

import com.example.clients_api.model.Client;
import com.example.clients_api.service.ClientService;
import com.example.clients_api.service.ExcelExportService;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ExcelExportService exportService;

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

    @GetMapping("/clients/export/xlsx")
    public ResponseEntity<byte[]> exportClientsToExcel(){
        try{
            List<Client> clients = clientService.getClients();
            byte[] excelBytes = exportService.exportClientsExcel(clients);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "clients.xlsx");
            return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
        } catch (WriteException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
