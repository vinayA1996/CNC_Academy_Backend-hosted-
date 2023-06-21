package com.api.cnc_academy.service;

import com.api.cnc_academy.domain.Course;

import java.util.List;

public interface CoureseService {
    public Course saveCourse(Course course);
    public List<Course> getCourse();
}
