package com.eelok.phoneFactory.controller;

import com.eelok.phoneFactory.DTO.PhoneDTO;
import com.eelok.phoneFactory.service.PhoneService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("phone")
public class PhoneController {

    private PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping(
            value = "/create/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> savePhoneByManufacturerId(@PathVariable long id, @RequestBody PhoneDTO phoneDTO) {
        PhoneDTO phoneDTOForReturn = null;
        try {
            phoneDTOForReturn = this.phoneService.savePhone(phoneDTO, id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(phoneDTOForReturn.getId())
                .toUri();
        httpHeaders.setLocation(location);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

}
