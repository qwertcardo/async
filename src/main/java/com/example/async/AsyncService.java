package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {

    @Async
    public void runAsync() throws InterruptedException {
        for (int i = 0; i < 999999999; i++) {
            Thread.sleep(1000L);
            System.out.print(i);
        }
    }
}
