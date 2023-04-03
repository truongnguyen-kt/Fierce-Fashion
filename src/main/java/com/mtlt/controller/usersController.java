package com.mtlt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtlt.entity.usersEntity;
import com.mtlt.service.usersService;
import com.mtlt.utils.requestDTO.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usersController {
    @Autowired
    usersService usService;
    private static ObjectMapper objectMapper = new ObjectMapper();
    @PostMapping("/createNewUser")
    public String createNewUser(@RequestBody String json) throws JsonProcessingException {
        usersEntity user = objectMapper.readValue(json, usersEntity.class);
        return usService.addNewUser(user);
    }

    @GetMapping("/login")
    public usersEntity checkLogin(@RequestBody String json) throws JsonProcessingException {
        loginRequest request = objectMapper.readValue(json, loginRequest.class);
        return usService.checkLogin(request.getId(), request.getPassword());
    }
}
