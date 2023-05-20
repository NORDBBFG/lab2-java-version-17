package com.example.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.stereotype.Service;
@ImportAutoConfiguration({FeignAutoConfiguration.class})

@Service
@Slf4j
public class LoginService {
    @Autowired
    private ModuleTWOApi moduleTWOApi;

    public ResponseDto login(UserDto loginDto){
        UserDto userDto = moduleTWOApi.getUserByName(loginDto.getName());
        ResponseDto responseDto = new ResponseDto();
        if (userDto.getName() != null && userDto.getPhone_number().equals(loginDto.getPhone_number())){
            responseDto.setMassage("Authorized ");
            return responseDto;
        }
        responseDto.setMassage("Not authorized");
        return responseDto;
    }

}
