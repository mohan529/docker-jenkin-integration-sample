package com.docker.image.jenkins.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String personId;
    private String name;
    private int age;
    private String address;
    private String designation;
    private String gender;
    private double salay;
}
