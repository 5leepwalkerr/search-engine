package com.skillbox.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {


    @GetMapping("/startIndexing")
    public ResponseEntity<?>startIndexing(){

    }

    @GetMapping("/stopIndexing")
    public ResponseEntity<?>stopIndexing(){

    }

    @GetMapping("/statistics")
    public ResponseEntity<?>statistics(){

    }

    @GetMapping("/search")
    public ResponseEntity<?>search(){

    }

    @PostMapping("/indexPage")
    public ResponseEntity<?>indexPage(String url){

    }
}
