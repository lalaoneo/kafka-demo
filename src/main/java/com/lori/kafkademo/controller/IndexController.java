package com.lori.kafkademo.controller;

import com.lori.kafkademo.sender.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private KafkaSender sender;

    @GetMapping("/index")
    public void inde(){
        sender.sendTest(6666);
    }
}
