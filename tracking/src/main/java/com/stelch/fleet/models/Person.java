package com.stelch.fleet.models;

import com.stelch.fleet.utils.WebEmbeddable;

import java.time.LocalDateTime;

public class Person extends WebEmbeddable {

    int id;
    String name;
    String phone;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Person(int id, String name, String phone, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Person(int id) {
        this.id = id;
    }

    public void fetch() {

    }

}
