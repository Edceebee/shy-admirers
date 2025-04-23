package com.aksh.shyadmirer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Permission {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
