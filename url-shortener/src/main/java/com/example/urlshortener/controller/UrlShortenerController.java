package com.example.urlshortener.controller;


import java.math.BigInteger;
import java.security.MessageDigest;
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
        try {
            // Generate MD5 hash
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(longUrl.getBytes()); //google.com ==> [1,0,0,1,] ==> xyz
            String hash = String.format("%032x", new BigInteger(1, digest));

            // Take first 6–8 characters to keep it short
            String shortCode = hash.substring(0, 8);

            // Create short URL
            String shortUrl = "http://short.ly/" + shortCode;

            return ResponseEntity.ok(shortUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating hash");
        }
    }
}