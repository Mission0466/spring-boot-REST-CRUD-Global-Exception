package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents;

    @PostConstruct
    public void loadData(){      // this helps us to act like a DB and also helps spring to load this data first and then run the application
        theStudents = new ArrayList<>();   //  by doiing this there is no need to rebuild the data again and again when we call the method getStudents only once data is created

        theStudents.add(new Student("KC1", "KC2"));
        theStudents.add(new Student("KC3", "KC4"));
        theStudents.add(new Student("KC", "KC"));
    }

    // define endpoint for "/student" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if(studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("StudentID not found "+ studentId );
        }

        return theStudents.get(studentId);
    }



}
