package com.stelch.fleet.models;

import com.stelch.fleet.utils.WebEmbeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Job extends WebEmbeddable {

    int id;
    Person sender;
    Person receiver;
    LocalDateTime serviceWindowStart;
    LocalDateTime serviceWindowEnd;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Job(Person sender, Person receiver, LocalDateTime serviceWindowStart, LocalDateTime serviceWindowEnd, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.sender = sender;
        this.receiver = receiver;
        this.serviceWindowStart = serviceWindowStart;
        this.serviceWindowEnd = serviceWindowEnd;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Job(int id) {
        this.id = id;
    }

    public void fetch() {
        // Fetch job details from the database or any other source
        // This is just a placeholder for the actual implementation
        System.out.println("Fetching job details for job ID: " + id);
    }

}
