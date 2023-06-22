package com.api.cnc_academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Course Not Found")
public class CourseNotFoundExcetion extends Exception {
}
