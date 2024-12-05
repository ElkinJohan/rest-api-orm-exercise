package com.elkin.restapiorm.domain.payload;

import com.elkin.restapiorm.domain.entity.CourseContent;
import lombok.Data;

import java.util.Set;

@Data
public class CourseForm {

    private Long id;
    private String courseName;
    private Set<CourseContent> courseContents;
}
