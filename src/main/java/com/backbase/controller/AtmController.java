package com.backbase.controller;

import com.backbase.entity.Atm;
import com.backbase.repository.AtmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AtmController {

    public static final String URL = "https://www.ing.nl/api/locator/atms/locatedin/";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AtmRepository atmRepository;

    @PostMapping(value = "/api/atm")
    public List<Atm> create(@RequestParam(value = "city") String city) throws IOException {

        String response = restTemplate.getForObject(URL + city, String.class);
        String jsonAtms = response.substring(5);

        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        List<Atm> atms = mapper.readValue(jsonAtms, typeFactory.constructCollectionType(List.class, Atm.class));
        atmRepository.save(atms);

        return atms;
    }

    @GetMapping(value = "/api/atm")
    public Iterable<Atm> retrieve(@RequestParam(value = "city") String city) {
        Iterable<Atm> atms = StringUtils.isBlank(city) ? atmRepository.findAll() : atmRepository.findByAddressCity(city);
        return atms;
    }
}