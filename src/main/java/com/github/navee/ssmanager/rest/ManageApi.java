package com.github.navee.ssmanager.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class ManageApi {
    @RequestMapping("ping")
    public String ping(){
        return null;
    }
}
