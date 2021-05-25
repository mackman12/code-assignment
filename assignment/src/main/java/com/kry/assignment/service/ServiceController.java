package com.kry.assignment.service;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired ServiceRepository serviceRepository;

    @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add")
	public void AddService(@RequestBody Service service){
        serviceRepository.SaveServiceToFile(service);
	}

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get")
    public List<Service> GetServices(){
        return serviceRepository.GetServices();
    }

}