package com.example.service;


import com.example.model.StorageDto;
import com.example.model.StorageEntity;
import com.example.repository.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {
    @Autowired
    private StorageRepo storageRepo;

    public void addProduct(StorageDto storageDTO){
        StorageEntity storageEntity =  new StorageEntity();
        storageEntity.setId(storageDTO.getId());
        storageEntity.setName(storageDTO.getName());
        storageEntity.setQuantity(storageDTO.getQuantity());
        storageEntity.setCategory(storageDTO.getCategory());
        storageEntity.setDescription(storageDTO.getDescription());
        storageRepo.save(storageEntity);
    }

    public List<StorageDto> getProductsByCategory(String category){
        List<StorageDto> products = new ArrayList<>();
        storageRepo.findByCategory(category);
        for (StorageDto product: products){
            StorageDto productDTO = new StorageDto();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setQuantity(product.getQuantity());
            productDTO.setCategory(product.getCategory());
            productDTO.setDescription(product.getDescription());
            products.add(productDTO);
        }
        return products;
    }
}