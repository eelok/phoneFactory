package com.eelok.phoneFactory.repository;



import com.eelok.phoneFactory.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    Phone save(Phone phone);

    List<Phone> findAllByName(String name);

    List<Phone> findAllByManufacturerId(long manufacturerId);

}
