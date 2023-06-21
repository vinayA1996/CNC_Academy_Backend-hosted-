package com.api.cnc_academy.repository;

import com.api.cnc_academy.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
