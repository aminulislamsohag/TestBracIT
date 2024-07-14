package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Batt;
import com.example.demo.service.BatServ;

@WebMvcTest(BatCont.class)
public class BatContrTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private BatServ batServ;

    @Test
    public void testGetBatteriesInRange() throws Exception {
        Batt battery1 = new Batt("Battery1", "12345", 100);
        Batt battery2 = new Batt("Battery2", "23456", 200);

        when(batServ.getBatteriesByPostcodeRange("10000", "40000")).thenReturn(Arrays.asList(battery1, battery2));

        mockMvc.perform(get("/batteries?startPostcode=10000&endPostcode=40000"))
                .andExpect(status().isOk());
    }
}
