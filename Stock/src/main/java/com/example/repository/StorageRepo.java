package com.example.repository;


import com.example.model.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StorageRepo extends JpaRepository<StorageEntity, Long> {
    List<StorageEntity> findByCategory (String category);
}
