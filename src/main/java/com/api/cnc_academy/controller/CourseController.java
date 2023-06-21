package com.api.cnc_academy.controller;


import com.api.cnc_academy.domain.Course;
import com.api.cnc_academy.service.CoureseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
public class CourseController {

    CoureseService coureseService;

    @Autowired
    public CourseController(CoureseService coureseService) {

        this.coureseService = coureseService;
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveCourse(@RequestBody Course course){

        return new ResponseEntity<>(coureseService.saveCourse(course), HttpStatus.ACCEPTED);


    }

    @GetMapping ("/get")
    public ResponseEntity<?> getCourse(){

        return new ResponseEntity<>(coureseService.getCourse(), HttpStatus.ACCEPTED);


    }
}
