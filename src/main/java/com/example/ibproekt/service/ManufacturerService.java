package com.example.ibproekt.service;

import com.example.ibproekt.entity.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> getALlManufacturers();

    Optional<Manufacturer> findById(long id);

    void deleteById(long id);

    void save(Manufacturer manufacturer);
}
