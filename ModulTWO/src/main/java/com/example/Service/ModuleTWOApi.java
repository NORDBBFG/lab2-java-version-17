package com.example.Service;


import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@ImportAutoConfiguration({FeignAutoConfiguration.class})

@Component
@FeignClient(name = "User", url = "localhost:1234")
public interface ModuleTWOApi {

    @GetMapping("/user/get")
    @ResponseBody UserDto getUserByName(@RequestParam String name);
}
