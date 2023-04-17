package com.example.javapipeline.controller;

import com.example.javapipeline.bean.Student;
import com.example.javapipeline.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {

    static List<Student> studentList;
    static {
        studentList = Arrays.asList(
           Student.builder().name("Name 1").id(1).build(),
           Student.builder().name("Name 2").id(2).build(),
           Student.builder().name("Name 3").id(3).build()
        ) ;
    }
    @GetMapping(value = "/")
    public ResponseEntity<Student> getStudentById(int id) {
        Student student =  studentList.stream().filter(stud -> stud.getId() == id)
                 .findFirst()
                .orElseThrow(() -> new RecordNotFoundException("Student with ID " +id + " not found"));

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
}
