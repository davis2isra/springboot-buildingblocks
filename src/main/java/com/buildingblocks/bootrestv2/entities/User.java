package com.buildingblocks.bootrestv2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message="Username is mandatory field. Please provide username")
    @Column(name="USER_NAME", length = 50, nullable = false, unique = true)
    private String username;

    @Size(min=2, message="FirstName should have atleast 2 characters")
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

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
