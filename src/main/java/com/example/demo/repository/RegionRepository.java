package com.example.demo.repository;

import com.example.demo.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface RegionRepository  extends JpaRepository<Region, Long> {
}
