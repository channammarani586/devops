package com.abhishek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Controller
public class StartApplication {

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        String hostname = "Unknown";
        try {
            hostname = InetAddress.getLocalHost().getHostName(); // Get Pod Name
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        model.addAttribute("title", "Spring Boot Kubernetes Deployment");
        model.addAttribute("msg", "This application is deployed on Kubernetes using Argo CD");
        model.addAttribute("pod", "Pod Name: " + hostname); // Display Pod Name
        model.addAttribute("sessionId", session.getId()); // Display Session ID for tracking

        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
