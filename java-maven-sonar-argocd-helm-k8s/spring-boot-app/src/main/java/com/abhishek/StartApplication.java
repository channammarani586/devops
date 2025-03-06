package com.abhishek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}

@Controller
class WebController {

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("title", "I have successfully built a Spring Boot application using Maven");
        model.addAttribute("msg", "This application is deployed on Kubernetes using Argo CD");
        return "index";
    }
}

@RestController
@RequestMapping("/api")
class InfoController {

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        Map<String, String> response = new HashMap<>();
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            String ip = InetAddress.getLocalHost().getHostAddress();
            response.put("message", "Hello, your request was processed by this pod!");
            response.put("pod_name", hostname);
            response.put("pod_ip", ip);
        } catch (UnknownHostException e) {
            response.put("error", "Could not retrieve pod details");
        }
        return response;
    }
}
