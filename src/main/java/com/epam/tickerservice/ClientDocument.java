package com.epam.tickerservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//mongodb annotation
@Document(collection = "client")
public class ClientDocument {

    @Id
    private int id;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
