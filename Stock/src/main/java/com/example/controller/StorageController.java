package com.example.controller;

import com.example.model.StorageDto;
import com.example.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Add product"})
@SwaggerDefinition(tags = {@Tag(name = "Add product", description = "Add new product to table and search by category")})

@Controller
@RequestMapping("/products")

public class StorageController {

    @Autowired
    private StorageService storageService;

    @Operation(summary = "Add new product")
    @ApiResponse(
            code = 200,
            message = "Add operation is completed"
    )
    @PostMapping("/add")
    public @ResponseBody void addProduct(@RequestBody StorageDto storageDTO) {
       storageService.addProduct(storageDTO);
    }

    @Operation(summary = "Search product by category")
    @ApiResponse(
            code = 200,
            message = "Searching complete!"
    )
    @GetMapping("/get")
    public @ResponseBody List<StorageDto> getProductsByCategory(@RequestParam String category){
      return storageService.getProductsByCategory(category);
    }
}