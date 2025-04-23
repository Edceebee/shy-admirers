package com.aksh.shyadmirer.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
}
