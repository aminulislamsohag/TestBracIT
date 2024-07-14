package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Batt;

public interface BatRepo extends JpaRepository<Batt, Long>  {
	 List<Batt> findByPostcodeBetween(String startPostcode, String endPostcode);
}
