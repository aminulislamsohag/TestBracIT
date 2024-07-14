package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Batt;
import com.example.demo.repository.BatRepo;

public class BatServTest {
	@InjectMocks
    private BatServ batService;

    @Mock
    private BatRepo batRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBatteriesByPostcodeRange() {
        Batt battery1 = new Batt("Battery1", "12345", 100);
        Batt battery2 = new Batt("Battery2", "23456", 200);
        List<Batt> batteries = Arrays.asList(battery1, battery2);

        when(batRepository.findByPostcodeBetween("10000", "30000")).thenReturn(batteries);

        List<Batt> result = batService.getBatteriesByPostcodeRange("10000", "30000");

        assertEquals(2, result.size());
        assertEquals("Battery1", result.get(0).getName());
    }
}
