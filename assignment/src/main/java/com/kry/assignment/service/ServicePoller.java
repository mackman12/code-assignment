package com.kry.assignment.service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ServicePoller{

    @Autowired ServiceRepository serviceRepository;

    @Scheduled(fixedRate = 1000)
    public void CheckReponseAndUpdateService(){
        List<Service> services = serviceRepository.GetServices();

        services.stream().forEach(sf -> {
            try {
                sf.setStatus(GetStatus(sf.getUrl()));
                sf.setLastChanged(LocalDateTime.now().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        serviceRepository.UpdateServices(services);
    }

    private String GetStatus(String url) throws IOException{
        try {
            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();

            if(conn.getResponseCode() == 200)
                return "ok";
            else 
                return "fail";
                
        } catch (ConnectException e) {
            return "fail";
        } catch (MalformedURLException e){
            return "fail";
        }
        
    }
}