package com.example.spring_boot_dars1.Repository;

import com.example.spring_boot_dars1.Entity.Dasturchi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.*;
import java.util.Optional;

public interface DasturchiRepository extends JpaRepository<Dasturchi,Integer> {
    boolean  existsByEmail(String email);
    boolean existsById(Integer id);




}
