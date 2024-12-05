package com.elkin.restapiorm.service.impl;

import com.elkin.restapiorm.domain.entity.Course;
import com.elkin.restapiorm.domain.entity.CourseContent;
import com.elkin.restapiorm.domain.payload.CourseForm;
import com.elkin.restapiorm.repository.CourseContentRepository;
import com.elkin.restapiorm.repository.CoursesRepository;
import com.elkin.restapiorm.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CoursesRepository coursesRepository;
    private final CourseContentRepository courseContentRepository;

    public CourseServiceImpl(CoursesRepository coursesRepository, CourseContentRepository courseContentRepository) {
        this.coursesRepository = coursesRepository;
        this.courseContentRepository = courseContentRepository;
    }

    @Override
    public Course addCourseWithContents(CourseForm courseForm) {
        Course course = new Course();

        course.setCourseName(courseForm.getCourseName());
        course.setCourseContents(courseForm.getCourseContents()
                .stream()
                .map(courseContent -> {
                    CourseContent cContent = courseContent;
                    if(cContent.getId() > 0){
                        cContent = courseContentRepository.findById(cContent.getId()).get();
                    }
                    cContent.addCourse(course);
                    return cContent;
                })
                .collect(Collectors.toSet()));

        return this.coursesRepository.save(course);
    }
}
