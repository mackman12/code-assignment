package com.kry.assignment.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceRepository {
    
    private ObjectMapper objectMapper;
    private String relServiceFolderPath = "src/main/resources/services/"; 

    @Autowired
    public ServiceRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void SaveServiceToFile(Service service){
        try {

            if(service.getKey() == null)
                service.setKey(UUID.randomUUID().toString());

            if(service.getCreateDate() == null)
                service.setCreateDate(LocalDateTime.now().toString());

            String fileName = "service_" + service.getKey() +  ".json";
            objectMapper.writeValue(new File(relServiceFolderPath + fileName), service);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Service> GetServices(){
        List<Service> services = new ArrayList<Service>();
        List<File> serviceFiles = GetAllJsonFilesFromFolder();

        serviceFiles.stream().forEach(sf -> {
            try {
                services.add(objectMapper.readValue(sf, Service.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return services;
    }

    public void UpdateServices(List<Service> services){
        services.stream().forEach(s -> SaveServiceToFile(s));
    }
    
    private List<File> GetAllJsonFilesFromFolder(){
        try {

            return Files.walk(Paths.get(relServiceFolderPath))
                .filter(p -> p.getFileName().toString().endsWith(".json"))
                .map(Path::toFile)
                .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}