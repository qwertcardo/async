package com.example.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/")
public class AsyncController {
    @Autowired
    private AsyncService service;

    @GetMapping
    public ResponseEntity<?> runAsync() throws InterruptedException {
        CompletableFuture.runAsync(() -> {
            try {
                service.runAsync();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return ResponseEntity.ok("teste");
    }
}
