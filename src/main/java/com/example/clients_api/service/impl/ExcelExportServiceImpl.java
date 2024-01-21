package com.example.clients_api.service.impl;


import com.example.clients_api.model.Client;
import com.example.clients_api.service.ExcelExportService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportServiceImpl implements ExcelExportService {
    @Override
    public byte[] exportClientsExcel(List<Client> clients) throws WriteException, IOException {
        WritableWorkbook workbook = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            workbook = Workbook.createWorkbook(byteArrayOutputStream);
            WritableSheet sheet = workbook.createSheet("Clients", 0);

            sheet.addCell(new Label(0, 0, "ID"));
            sheet.addCell(new Label(1, 0, "FirstName"));
            sheet.addCell(new Label(2, 0, "LastName"));
            sheet.addCell(new Label(3, 0, "Contact Number"));
            sheet.addCell(new Label(4, 0, "Email"));
            sheet.addCell(new Label(5, 0, "Country"));


            for (int i = 0; i < clients.size(); i++) {
                Client client = clients.get(i);
                sheet.addCell(new jxl.write.Number(0, i + 1, client.getId()));
                sheet.addCell(new Label(1, i + 1, client.getFirstName()));
                sheet.addCell(new Label(2, i + 1, client.getLastName()));
                sheet.addCell(new Label(3, i + 1, client.getContactNumber()));
                sheet.addCell(new Label(4, i + 1, client.getEmail()));
                sheet.addCell(new Label(5, i + 1, client.getCountry()));
            }

            workbook.write();
        } finally {
            // Close the workbook even if an exception occurs
            if (workbook != null) {
                workbook.close();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
