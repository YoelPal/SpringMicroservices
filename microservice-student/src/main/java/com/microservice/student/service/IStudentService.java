package com.microservice.student.service;

import java.util.List;

import com.microservice.student.entities.Student;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    void deleteById(Long id);
    
    List<Student> findByIdCourse(Long idCourse);
    

}
