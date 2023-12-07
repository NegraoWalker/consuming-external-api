package com.walker.consumingexternalapi.controller;

import com.walker.consumingexternalapi.dto.ConsultaCepDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consulta")
public class ConsultaCepController {
    @GetMapping("/{cep}")
    public ConsultaCepDto consultaCEP(@PathVariable String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConsultaCepDto> responseEntity = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/",cep), ConsultaCepDto.class);
        return responseEntity.getBody();
    }
}
