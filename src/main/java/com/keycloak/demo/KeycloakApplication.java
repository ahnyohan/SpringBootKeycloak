package com.keycloak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class KeycloakApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakApplication.class, args);
    }

    @GetMapping(path = "/")
    @ResponseBody
    public String index() {
        return "hello world";
    }

    @GetMapping(path = "/user")
    @ResponseBody
    public String user() {
        return "user!!!";
    }

    @GetMapping(path = "/noAuth")
    @ResponseBody
    public String noAuth() {
        return "noAuth!!!";
    }

}
