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

    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer findManufacturerById(long manufacturerId) throws Exception {
        Manufacturer manufacturerDB = manufacturerRepository.findById(manufacturerId);
        if (manufacturerDB == null) {
            throw new Exception(String.format("manufacturer with id= %d is now found", manufacturerId));
        }
        return manufacturerDB;
    }

    public void deleteManufacturer(Manufacturer manufacturer){
        this.manufacturerRepository.delete(manufacturer);
    }
}
