package com.eelok.phoneFactory.controller;

import com.eelok.phoneFactory.model.Manufacturer;
import com.eelok.phoneFactory.model.Phone;
import com.eelok.phoneFactory.service.ManufacturerService;
import com.eelok.phoneFactory.service.PhoneService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
    private ManufacturerService manufacturerService;
    private PhoneService phoneService;

    public ManufacturerController(ManufacturerService manufacturerService, PhoneService phoneService) {
        this.manufacturerService = manufacturerService;
        this.phoneService = phoneService;
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> saveManufacturer(@RequestBody Manufacturer manufacturer) {
        Manufacturer savedManufacturer = manufacturerService.saveManufacturer(manufacturer);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedManufacturer.getId())
                .toUri();
        httpHeaders.setLocation(location);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(
            path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getManufacturer(@PathVariable long id) {
        try {
            Manufacturer manufacturerDB = manufacturerService.findManufacturerById(id);
            return new ResponseEntity<>(manufacturerDB, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(
            value = "/{manufacturerId}/phones",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> findAllPhonesByManufacturerId(@PathVariable long manufacturerId) {
        List<Phone> listOfPhones = this.phoneService.findAllPhonesByManufacturerId(manufacturerId);
        return new ResponseEntity<>(listOfPhones, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable long id) {
        try {
            Manufacturer manufacturerDB = this.manufacturerService.findManufacturerById(id);
            this.manufacturerService.deleteManufacturer(manufacturerDB);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
