package com.example.Controller;

import com.example.Service.LoginService;
import com.example.Service.ResponseDto;
import com.example.Service.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"User authorization"})
@SwaggerDefinition(tags = {@Tag(name = "User authorization", description = "Store methods for user auth")})

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "Chek if user can be authorized by login and password")
    @ApiResponse(
            code = 200,
            message = "Result of auth is 50% authorized",
            response = ResponseDto.class
    )
    @PostMapping("/login")
    public @ResponseBody ResponseDto logIn(@RequestBody UserDto userDto){
        return loginService.login(userDto);
    }

}
