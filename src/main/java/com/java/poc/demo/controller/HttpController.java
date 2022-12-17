package com.java.poc.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpController {
    @RequestMapping("/hello")
    @ResponseBody
    public ResponseEntity<String> hello(@RequestParam( value = "name", defaultValue = "John") String name) {
        return ResponseEntity.ok()
                .body("Hello " + name);
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/html")
    public String index(Model model) {
        return "index";
    }

}
