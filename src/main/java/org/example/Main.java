package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Contact;
import org.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        User user;
        try {


            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("data.json");
            InputStreamReader reader = new InputStreamReader(inputStream);

            Gson gson = new GsonBuilder()
                    .create();

            Type userType = new TypeToken<User>() {}.getType();
            user = gson.fromJson(reader, userType);

            List<Contact> contacts = user.getContacts();
            contacts.sort(Comparator.comparing(Contact::getLastName));

            System.out.println("----------------------");
            System.out.println( gson.toJson(contacts));
            System.out.println("----------------------");

            reader.close();
            inputStream.close();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }

    }



}