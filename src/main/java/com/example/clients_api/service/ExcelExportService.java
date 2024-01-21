package com.example.clients_api.service;

import com.example.clients_api.model.Client;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.List;

public interface ExcelExportService {
    byte[] exportClientsExcel(List<Client> clients) throws WriteException, IOException;
}
