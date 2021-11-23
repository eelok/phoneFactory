package com.eelok.phoneFactory.service;

import com.eelok.phoneFactory.model.Manufacturer;
import com.eelok.phoneFactory.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public Manufacturer saveManufacturer(Manufacturer manufacturer){
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer findManufacturerById(long manufacturerId){
        return manufacturerRepository.findById(manufacturerId);
    }
}
