package com.buildingblocks.bootrestv2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="USER_NAME", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name="FIRST_NAME", length = 50, nullable=false)
    private String firstname;
    @Column(name="LAST_NAME", length = 50, nullable=false)
    private String lastname;
    @Column(name="EMAIL_ADDRESS", length = 50, nullable=false)
    private String email;
    @Column(name="ROLE", length = 50, nullable=false)
    private String role;

    @Column(name="SSN", length=50, nullable=false, unique = true)
    private String ssn;
}
