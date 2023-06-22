package com.api.cnc_academy.service;

import com.api.cnc_academy.domain.Course;
import com.api.cnc_academy.exception.CourseNotFoundExcetion;

import java.util.List;

public interface CoureseService {
    public Course saveCourse(Course course);
    public List<Course> getCourse();
    public Course findCourseByid(int id) throws CourseNotFoundExcetion;
    public boolean deleteCourse(int id) throws CourseNotFoundExcetion;
    public Course editCourse(Course course) throws CourseNotFoundExcetion;
}
