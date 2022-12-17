package com.java.poc.demo.controller;

import com.java.poc.demo.model.Report;
import com.java.poc.demo.utils.LoremIpsumGenerator;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class MainController {

    private static Map<String, List<Report>> reportCache = new HashMap<>();

    static{
        reportCache = Report.generateReportInBulk();
    }

    @GetMapping("/feedReports")
    public Map<String, List<Report>> feedReports() {
        return reportCache;
    }

    @GetMapping("/regenerateReports")
    public Map<String, String> regenerateReports() {
        reportCache = Report.generateReportInBulk();
        return Map.of("status","report regeneration success");
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of("status","up", "version", "0.1");
    }

    @GetMapping("/get")
    public Map<String,String> get(
            @RequestParam(name = "w", defaultValue = "Portal") String w,
            @RequestParam(name = "wc", defaultValue = "0") int wc
    ) {
        if(wc == 0) return Map.of("data",w);
        return Map.of("data",LoremIpsumGenerator.getText(wc));
    }

    @GetMapping("/getanalysts")
    public List<Report> getanalysts(){
        return reportCache.get("ANALYST");
    }

    @GetMapping("/companies")
    public List<Report> companies(){
        return reportCache.get("COMPANY");
    }

    @GetMapping("/getperiodicals")
    public List<Report> getperiodicals(){
        return reportCache.get("PERIODICALS");
    }

    @GetMapping("/getcollections")
    public List<Report> getcollections(){
        return reportCache.get("COLLECTIONS");
    }


    @GetMapping("/geta")
    public Map<String,String> geta(){
           return get("",300);
    }

    @GetMapping("/getb")
    public Map<String,String> getb(){
        return get("",400);
    }

    @GetMapping("/getc")
    public Map<String,String> getc(){
        return get("",500);
    }

    @GetMapping("/getd")
    public Map<String,String> getd(){
        return get("",600);
    }

    @GetMapping("/gete")
    public Map<String,String> gete(){
        return get("",700);
    }



}
