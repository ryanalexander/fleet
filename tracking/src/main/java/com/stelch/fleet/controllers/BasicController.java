package com.stelch.fleet.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String index() {
        return "This is the fleet internal api. Please refer to product docs for public api.";
    }

}
