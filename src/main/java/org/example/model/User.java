package org.example.model;


import lombok.Data;

import java.util.List;

@Data
public class User {
    private String firstName;
    private String lastName;
    private List<Contact> contacts;

}
