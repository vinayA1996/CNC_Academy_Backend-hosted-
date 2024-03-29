package com.api.cnc_academy.controller;

import com.api.cnc_academy.domain.Course;
import com.api.cnc_academy.exception.CourseALreadyExists;
import com.api.cnc_academy.exception.CourseNotFoundExcetion;
import com.api.cnc_academy.service.CoureseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
public class CourseController {
    private CoureseService coureseService;
    @Autowired
    public CourseController(CoureseService coureseService) {
        this.coureseService = coureseService;
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) throws CourseALreadyExists {
        return new ResponseEntity<>(coureseService.saveCourse(course), HttpStatus.CREATED);
    }
    @GetMapping ("/get")
    public ResponseEntity<?> getCourse(){
        return new ResponseEntity<>(coureseService.getCourse(), HttpStatus.OK);
    }
    @GetMapping ("/get/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) throws CourseNotFoundExcetion {
        return new ResponseEntity<>(coureseService.findCourseByid(id), HttpStatus.OK);
    }
    @PutMapping("/edit")
    public ResponseEntity<?> editCourse(@RequestBody Course course) throws CourseNotFoundExcetion {
        return new ResponseEntity<>(coureseService.editCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) throws CourseNotFoundExcetion {
        return new ResponseEntity<>(coureseService.deleteCourse(id), HttpStatus.OK);
    }

}
