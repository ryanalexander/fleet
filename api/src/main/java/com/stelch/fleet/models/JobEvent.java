package com.stelch.fleet.models;

import com.stelch.fleet.utils.WebEmbeddable;

import java.time.LocalDateTime;

public class JobEvent extends WebEmbeddable {

    int id;
    Job job;
    String event;
    LocalDateTime timestamp;
    String comment;
    String driver;
    double lat;
    double lon;
    String metadata;

    public JobEvent(Job job, String event, LocalDateTime timestamp, String comment, String driver, double lat, double lon, String metadata) {
        this.job = job;
        this.event = event;
        this.timestamp = timestamp;
        this.comment = comment;
        this.driver = driver;
        this.lat = lat;
        this.lon = lon;
        this.metadata = metadata;
    }

    public JobEvent(int id) {
        this.id = id;
    }

    public void fetch() {
        // Fetch job event details from the database or any other source
        // This is just a placeholder for the actual implementation
        System.out.println("Fetching job event details for job event ID: " + id);
    }

}
