package com.eelok.phoneFactory.controller;

import com.eelok.phoneFactory.model.Manufacturer;
import com.eelok.phoneFactory.service.ManufacturerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
    private ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
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
        Manufacturer manufacturerDB = manufacturerService.findManufacturerById(id);
        if (manufacturerDB == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(manufacturerDB, HttpStatus.OK);
    }
}
