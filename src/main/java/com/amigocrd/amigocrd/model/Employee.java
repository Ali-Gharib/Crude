package com.amigocrd.amigocrd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id ;
    private String name ;
    private String email ;
    private String jobTitle ;
    private String phone ;
    private String imageUrl ;
    @Column(nullable = false, updatable = false)
    private String employeeCode ;

}
