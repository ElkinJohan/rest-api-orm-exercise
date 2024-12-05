package com.elkin.restapiorm.service;

import com.elkin.restapiorm.domain.entity.Course;
import com.elkin.restapiorm.domain.payload.CourseForm;

public interface CourseService {

    Course addCourseWithContents(CourseForm courseForm);
}
