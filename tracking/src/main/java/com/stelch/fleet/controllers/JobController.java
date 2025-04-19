package com.stelch.fleet.controllers;

import com.google.gson.Gson;
import com.stelch.fleet.handlers.ResponseHandler;
import com.stelch.fleet.models.Job;
import com.stelch.fleet.models.JobEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController()
@RequestMapping(value = "/api/v1/job")
public class JobController {

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Object> getJob(@PathVariable int id) {
        Job job = new Job(id);
        job.fetch();

        return new ResponseEntity<>(ResponseHandler.getResponse(job.toObject(), true), HttpStatus.OK);
    }

    @GetMapping(value = "{id}/events", produces = "application/json")
    public ResponseEntity<Object> getJobEvents(@PathVariable int id) {
        // return hello world json
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Hello World");
        response.put("jobId", id);
        return new ResponseEntity<>(ResponseHandler.getResponse(response, true), HttpStatus.OK);
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<Object> createJob() {
        // return hello world json
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Hello World");
        return new ResponseEntity<>(ResponseHandler.getResponse(response, true), HttpStatus.OK);
    }

    @PostMapping(value = "{id}/events", produces = "application/json")
    public ResponseEntity<Object> createJobEvent(@PathVariable int id, @RequestBody String body) {
        Gson gson = new Gson();
        JobEvent jobEvent = gson.fromJson(body, JobEvent.class);
        Job job = new Job(id);
        job.save();
        jobEvent.save();
        return new ResponseEntity<>(ResponseHandler.getResponse(null, true), HttpStatus.OK);
    }

    @PutMapping(value = "{id}/events", produces = "application/json")
    public ResponseEntity<Object> updateJobEvents(@PathVariable int id) {
        // return hello world json
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Hello World");
        response.put("jobId", id);
        return new ResponseEntity<>(ResponseHandler.getResponse(response, true), HttpStatus.OK);
    }
}
