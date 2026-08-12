package com.example;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String profile() {
        return "<!DOCTYPE html>"
            + "<html><head><meta charset=\"UTF-8\">"
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
            + "<title>Paul Foseh</title>"
            + "<style>"
            + "body{margin:0;min-height:100vh;display:flex;align-items:center;"
            + "justify-content:center;background:#f4f7fb;font-family:Arial,sans-serif;"
            + "color:#172033;text-align:center}"
            + "main{padding:48px 28px}"
            + "h1{margin:0 0 16px;font-size:clamp(2.5rem,7vw,5rem)}"
            + "p{max-width:900px;margin:0;font-size:clamp(1rem,2.4vw,1.5rem);"
            + "line-height:1.6;color:#526079}"
            + "</style></head><body><main>"
            + "<h1>Paul Foseh</h1>"
            + "<p>Senior DevOps, Cloud, SRE &amp; DevSecOps Engineer | "
            + "AWS | Azure | GCP | Kubernetes | Terraform | CI/CD | "
            + "Platform Automation &amp; Reliability</p>"
            + "</main></body></html>";
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of(
            "application", "java-app",
            "status", "OK"
        );
    }
}
