package com.eelok.phoneFactory.service;

import com.eelok.phoneFactory.DTO.PhoneDTO;
import com.eelok.phoneFactory.model.Phone;
import org.springframework.stereotype.Component;

@Component
public class CustomModelMapper {

    public CustomModelMapper() {
    }

    public Phone mapPhoneDTOtoPhone(PhoneDTO phoneDTO){
        Phone phone = new Phone();
        phone.setName(phoneDTO.getName());
        phone.setQuantity(phoneDTO.getQuantity());
        phone.setReleaseDate(phoneDTO.getReleaseDate());
        return phone;
    }

    public PhoneDTO mapPhoneToPhoneDTO(Phone phone){
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(phone.getId());
        phoneDTO.setName(phone.getName());
        phoneDTO.setQuantity(phone.getQuantity());
        phoneDTO.setReleaseDate(phone.getReleaseDate());
        return phoneDTO;
    }
}
