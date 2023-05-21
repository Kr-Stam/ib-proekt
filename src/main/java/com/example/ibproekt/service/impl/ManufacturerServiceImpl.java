package com.example.ibproekt.service.impl;

import com.example.ibproekt.entity.Manufacturer;
import com.example.ibproekt.repository.ManufacturerRepository;
import com.example.ibproekt.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> getALlManufacturers() {
        return manufacturerRepository.findAll();
    }
}
