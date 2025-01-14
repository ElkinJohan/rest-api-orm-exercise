package com.elkin.restapiorm.controller;

import com.elkin.restapiorm.domain.entity.Course;
import com.elkin.restapiorm.domain.payload.CourseForm;
import com.elkin.restapiorm.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course addCourse(@RequestBody CourseForm courseForm){
        return this.courseService.addCourseWithContents(courseForm);
    }
}
