package com.eelok.phoneFactory.service;

import com.eelok.phoneFactory.DTO.PhoneDTO;
import com.eelok.phoneFactory.model.Manufacturer;
import com.eelok.phoneFactory.model.Phone;
import com.eelok.phoneFactory.repository.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;
    private ManufacturerService manufacturerService;
    private CustomModelMapper customModelMapper;

    public PhoneService(PhoneRepository phoneRepository, ManufacturerService manufacturerService, CustomModelMapper customModelMapper) {
        this.phoneRepository = phoneRepository;
        this.manufacturerService = manufacturerService;
        this.customModelMapper = customModelMapper;
    }

    public PhoneDTO savePhone(PhoneDTO phoneDTO, long manufacturerId) throws Exception {
        Manufacturer manufacturerFromDB = manufacturerService.findManufacturerById(manufacturerId);
        if (manufacturerFromDB == null) {
            throw new Exception(String.format("no manufacturer with id= %d", manufacturerId));
        }
        Phone phone = this.customModelMapper.mapPhoneDTOtoPhone(phoneDTO);
        if(phoneNameIsExists(phone)){
            throw new Exception(String.format("phone with name= %s is already exists", phone.getName()));
        }
        phone.setManufacturer(manufacturerFromDB);
        Phone savedPhone = this.phoneRepository.save(phone);
        return this.customModelMapper.mapPhoneToPhoneDTO(savedPhone);
    }
    
    private boolean phoneNameIsExists(Phone phone){
        List<Phone> allPhones = this.phoneRepository.findAllByName(phone.getName());
        if(allPhones.isEmpty()){
            return false;
        }
        return true;
    }
}
