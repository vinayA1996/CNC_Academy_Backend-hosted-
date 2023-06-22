package com.api.cnc_academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Course already present")
public class CourseALreadyExists extends Exception{
}
