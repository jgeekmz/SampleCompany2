package com.green.samplecompany2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlatkov
 */
@Controller
@Slf4j
public class DashboardController {

    @GetMapping("/")
    public String dashboard() {
        log.info("Inside dashboard controller!");
        return "index";
    }

}
