package com.dheeshi.movie_streaming_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/stream")
public class MovieStreamController {

    public static final Logger log = Logger.getLogger(MovieStreamController.class.getName());
//public static final String VIDEO_DIRECTORY = "C:\\Users\\User\\Videos\\";

    @Autowired
    private MovieCatalogService movieCatalogService;

    @GetMapping("/with-id/{videoInfoId}")
    public ResponseEntity<Void> streamVideoById(@PathVariable("videoInfoId") Long videoInfoId) {

        // 1. Fetch the public URL from the Movie Catalog Service
        String moviePath = movieCatalogService.getMoviePath(videoInfoId);
        // ... (Log resolved path)

        if (moviePath == null || moviePath.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 2. Return a 302 Redirect to the public URL
        try {
            // HttpStatus.FOUND (302) tells the browser to look at the Location header
            // and make a new request to that URL.
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(new URI(moviePath))
                    .build();
        } catch (Exception e) {
            // Handle exceptions (like an invalid URL string)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
