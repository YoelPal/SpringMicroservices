package com.microservice.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.controller.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

    private ICourseRepository courseRepository;

    private StudentClient studentClient;

    public CourseServiceImpl(ICourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        
        Course course = courseRepository.findById(idCourse).orElse(null);

        List<StudentDTO> studentDTOList = studentClient.findByIdCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course != null ? course.getName() : null)
                .teacherName(course != null ? course.getTeacherName() : null)
                .studentDTOList(studentDTOList)
                .build();
    }

 
}
