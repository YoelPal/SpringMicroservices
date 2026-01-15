package com.microservice.course.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/courses")
public class CourseController {

    private ICourseService courseService;
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Course>> getAllStudents() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity <Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }
    @PutMapping("/save")
    public ResponseEntity <Course> saveCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
    }


    @GetMapping("/students/{idCourse}")
    public ResponseEntity<?> getStudentsByIdCourse(@PathVariable Long idCourse) {
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));
    }
}

