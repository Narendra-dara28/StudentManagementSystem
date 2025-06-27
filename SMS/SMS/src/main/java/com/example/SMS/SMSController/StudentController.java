package com.example.SMS.SMSController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SMS.SMSDTO.StudentDTO;
import com.example.SMS.SMSEntity.Student;
import com.example.SMS.SMSService.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	  @Autowired
	    private StudentService studentService;

	    @PostMapping
	    public ResponseEntity<Student> addStudent(@RequestBody StudentDTO studentDTO) {
	        Student savedStudent = studentService.createStudent(studentDTO);
	        return ResponseEntity.ok(savedStudent);
	    }

	    @GetMapping
	    public ResponseEntity<List<Student>> getAllStudents() {
	        return ResponseEntity.ok(studentService.getAllStudents());
	    }
	

}
