package com.Data.DataShowing.controller;

import com.Data.DataShowing.Stud;
import com.Data.DataShowing.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping("/data")
    public List<Stud> getAllData(){
        return dataService.getAllData();
    }
}
