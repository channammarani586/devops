package com.abhishek;
  
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}

@RestController
class PodInfoController {

    @GetMapping("/")
    public String getPodIP() {
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            return "Pod IP: " + ipAddress;
        } catch (UnknownHostException e) {
            return "Pod IP: Unknown";
        }
       }
    }
