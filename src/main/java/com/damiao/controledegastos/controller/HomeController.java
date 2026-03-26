package com.damiao.controledegastos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public Map<String, Object> index() {
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("app_name", "Controle de Gastos API");
        info.put("version", "1.0.0-SNAPSHOT");
        info.put("status", "UP");
        info.put("author", "Damião");
        info.put("docs_url", "/swagger-ui/index.html");

        return info;
    }
}
