package com.api.cnc_academy.service;

import com.api.cnc_academy.domain.Course;
import com.api.cnc_academy.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoureseServiceImpl implements  CoureseService{

    CourseRepo courseRepo;
@Autowired
    public CoureseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }
}
