package com.example.spring_boot_dars1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Dasturchi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String ism;
    @Column(nullable = false)
    private  String familya;
    @Column(nullable = false,unique = true)
    private  String email;
    @Column(nullable = false,unique = true)
    private  String tel_raqam;
    @Column(nullable = false)
    private  String manzil;



}
