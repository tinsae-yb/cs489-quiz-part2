package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Contact {
    private String firstName;
    private String lastName;
    private String company;
    private String job;
    private List<Email> emails;
    private List<Phone> phones;
}
