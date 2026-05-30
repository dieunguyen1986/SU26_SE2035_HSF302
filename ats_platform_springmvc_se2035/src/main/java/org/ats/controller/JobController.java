package org.ats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @RequestMapping(method = RequestMethod.POST)
    public  String createJob(){

        return null;
    }

    @GetMapping
    public String listAll(){

        return null;
    }

    @GetMapping(path = "/{id}")
    public String getById(){
        return null;
    }
}
