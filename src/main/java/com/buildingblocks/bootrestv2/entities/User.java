package com.buildingblocks.bootrestv2.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
// @JsonIgnoreProperties({"firstname", "lastname"}) - Static Filtering @JsonIgnore
//@JsonFilter(value="userFilter") - Used for MappingJacksonValue filtering Section
public class User extends RepresentationModel<User> {

    @Id
    @GeneratedValue
    @JsonView(Views.External.class)
    private Long id;

    @NotEmpty(message="Username is mandatory field. Please provide username")
    @Column(name="USER_NAME", length = 50, nullable = false, unique = true)
    @JsonView(Views.External.class)
    private String username;

    @Size(min=2, message="FirstName should have atleast 2 characters")
    @Column(name="FIRST_NAME", length = 50, nullable=false)
    @JsonView(Views.External.class)
    private String firstname;
    @Column(name="LAST_NAME", length = 50, nullable=false)
    @JsonView(Views.External.class)
    private String lastname;
    @Column(name="EMAIL_ADDRESS", length = 50, nullable=false)
    @JsonView(Views.External.class)
    private String email;
    @Column(name="ROLE", length = 50, nullable=false)
    @JsonView(Views.Internal.class)
    private String role;

    @Column(name="SSN", length=50, nullable=true, unique = true)
    //@JsonIgnore - Static filtering @JsonIgnore
    @JsonView(Views.Internal.class)
    private String ssn;

    @OneToMany(mappedBy = "user")
    @JsonView(Views.Internal.class)
    private List<Order> orders;

    @Column(name = "ADDRESS")
    private String address;
}
