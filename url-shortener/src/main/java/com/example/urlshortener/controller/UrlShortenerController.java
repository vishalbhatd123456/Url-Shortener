package com.example.urlshortener.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController {
    @GetMapping("/")
    public String home() {
    return "URL Shortener API is running!";
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String longUrl) {
        String dummyShortUrl = "http://short.ly/abc123";
        return ResponseEntity.ok(dummyShortUrl);
    }
}