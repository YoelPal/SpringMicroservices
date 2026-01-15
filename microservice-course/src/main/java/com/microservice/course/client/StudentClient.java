package com.microservice.course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.course.controller.dto.StudentDTO;


@FeignClient(name = "msvc-student", path = "localhost:8090/students")
public interface StudentClient {

    @GetMapping("/findByIdCourse/{idCourse}")
    List<StudentDTO> findByIdCourse(@PathVariable Long idCourse);

}
