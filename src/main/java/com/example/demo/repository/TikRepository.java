package com.example.demo.repository;

import com.example.demo.model.Tik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface TikRepository extends JpaRepository<Tik, Long> {
}
