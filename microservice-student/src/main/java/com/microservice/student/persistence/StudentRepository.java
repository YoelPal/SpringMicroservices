package com.microservice.student.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.student.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


List<Student> findByIdCourse(Long idCourse);

@Query("SELECT s FROM Student s WHERE s.idCourse = ?1")
List<Student> findAllStudent(Long idCourse);


}
