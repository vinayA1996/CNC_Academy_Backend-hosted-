package com.api.cnc_academy.service;

import com.api.cnc_academy.domain.Course;
import com.api.cnc_academy.exception.CourseALreadyExists;
import com.api.cnc_academy.exception.CourseNotFoundExcetion;
import com.api.cnc_academy.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoureseServiceImpl implements  CoureseService{

    CourseRepo courseRepo;
@Autowired
    public CoureseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course saveCourse(Course course) throws CourseALreadyExists {
    if (courseRepo.findById(course.getId()).isPresent()){
        throw new CourseALreadyExists();
    }

        return courseRepo.save(course);
    }

    @Override
    public List<Course> getCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Course findCourseByid(int id) throws CourseNotFoundExcetion {
    if (courseRepo.findById(id).isEmpty()){
        throw  new CourseNotFoundExcetion();
    }
        return courseRepo.findById(id).get();
    }

    @Override
    public boolean deleteCourse(int id) throws CourseNotFoundExcetion {
        if (courseRepo.findById(id).isEmpty()){
            throw  new CourseNotFoundExcetion();
        }
         courseRepo.deleteById(id);
        return true;
    }

    @Override
    public Course editCourse(Course course) throws CourseNotFoundExcetion {
        if (courseRepo.findById(course.getId()).isEmpty()){
            throw  new CourseNotFoundExcetion();
        }

        Course courseInDatabase= courseRepo.findById(course.getId()).get();

        if(!course.getName().equals(courseInDatabase.getName())&& course.getName()!=null ){
            courseInDatabase.setName(course.getName());
        }
        if(!course.getDuration().equals(courseInDatabase.getDuration())&& course.getDuration()!=null ){
            courseInDatabase.setDuration(course.getDuration());
        }
        if(!course.getInfo().equals(courseInDatabase.getInfo())&& course.getInfo()!=null ){
            courseInDatabase.setInfo(course.getInfo());
        }
        if(course.getFees()!=courseInDatabase.getFees() && course.getFees()!=0 ){
            courseInDatabase.setFees(course.getFees());
        }

        return courseRepo.save(courseInDatabase);
    }


}
