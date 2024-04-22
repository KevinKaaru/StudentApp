package com.restApi.demo.controller;

import com.restApi.demo.entity.Student;
import com.restApi.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class StudentController {
    @Autowired
    StudentRepository repo;
    //get all the students
    //localhost:8080/students(in postman)
    @GetMapping("/students")
    public List<Student> getAllStudents(){
           List<Student> students = repo.findAll();
       return  students;

    }
    //localhost:8080/students/1
    @GetMapping("/students/{id}")
    public  Student getStudent(@PathVariable int id) {
      Student student=repo.findById(id).get();
        return  student;

    }
    @PostMapping("/student/add")
   public void createStudent(@RequestBody Student student){

        repo.save(student);


   }
   @PutMapping("/student/update/{id}")
   public Student updateStudents(@PathVariable int id) {
       Student student = repo.findById(id).get();
       student.setName("MUNGAI");
       student.setPercentage(92);
       repo.save(student);
       return student;
   }
   @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id){
       Student student= repo.findById(id).get();
        repo.delete(student);
   }



}
