package com.microservice.course.service;

import java.util.List;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

public interface ICourseService {

    Course findById(Long id);

    Course save(Course course);

    List<Course> findAll();

    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);

}
