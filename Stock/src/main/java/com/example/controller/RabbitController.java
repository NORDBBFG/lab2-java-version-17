package com.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rabbit")
@Slf4j
public class RabbitController {

    @Autowired
    public AmqpTemplate template;

    @PostMapping("/send")
    public String send(@RequestBody String message){
        log.info("Send to user queue");
        template.convertAndSend("userQueue", message);
        return "Init to userQueue queue";
    }
}
