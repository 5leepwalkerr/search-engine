package com.skillbox.project.controller;

import com.skillbox.project.config.SitesList;
import com.skillbox.project.repository.PageRepository;
import com.skillbox.project.repository.SiteRepository;
import com.skillbox.project.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    private SitesList sitesList;
    @Autowired
    PageRepository pageRepository;
    @Autowired
    SiteRepository siteRepository;
    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/startIndexing")
    public ResponseEntity<?>startIndexing(){
       // return new ResponseEntity<>(HttpStatus.FOUND);
    }

    /*
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

     */
}
