package com.eelok.phoneFactory.repository;

import com.eelok.phoneFactory.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    Manufacturer save(Manufacturer manufacturer);

    Manufacturer findById(long manufacturerId);
}
