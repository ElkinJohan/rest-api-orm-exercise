package com.elkin.restapiorm.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "course_contents")
public class CourseContent {

    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "courseContents")//es el atributo de Course del Set
    @JsonIgnore
    private Set<Course> course = new HashSet<>();

    private String content;

    public void addCourse(Course course){
        this.course.add(course);
    }
}
