package com.biyikli.register.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// lombok anotasyonları
@Data
@NoArgsConstructor

// Hibernate'in, bu sınıfın bir veritabanı tablosu olduğunu anlaması
// ve sınıfın component scan sürecine dahil olmasını sağlayan anotasyon.
@Entity
// Tablo ado
@Table(name="users")
public class User {

    // Primary Key
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // İsim-soyisim sütunu
    @Column(name="full_name")
    @NotNull
    private String name;

    // email sütunu
    @Column(name="email")
    @NotNull
    private String email;

    // parola sütunu
    @Column(name="passwd")
    @NotNull
    private String password;
}
