package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Batt;
import com.example.demo.repository.BatRepo;

@Service
public class BatServ {
	@Autowired
    private BatRepo batRepo;

    public Batt saveBattery(Batt batt) {
        return batRepo.save(batt);
    }

    public List<Batt> getBatteriesByPostcodeRange(String startPostcode, String endPostcode) {
        return batRepo.findByPostcodeBetween(startPostcode, endPostcode);
    }
}
