package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Batt {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
    private String postcode;
    private int wattCapacity;
  
	public Batt( String name, String postcode, int wattCapacity) {	
		this.name = name;
		this.postcode = postcode;
		this.wattCapacity = wattCapacity;
	}
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public int getWattCapacity() {
		return wattCapacity;
	}
	public void setWattCapacity(int wattCapacity) {
		this.wattCapacity = wattCapacity;
	}


    
}
