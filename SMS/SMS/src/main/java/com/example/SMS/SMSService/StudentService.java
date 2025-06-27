package com.example.SMS.SMSService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SMS.SMSDTO.MarkDTO;
import com.example.SMS.SMSDTO.StudentDTO;
import com.example.SMS.SMSEntity.Student;
import com.example.SMS.SMSRepository.StudentRepository;
import com.example.SMS.SMSEntity.Mark;



@Service
public class StudentService {
	
	   @Autowired
	    private StudentRepository studentRepo;

	    public Student createStudent(StudentDTO dto) {
	        Student student = new Student();
	        student.setName(dto.getName());
	        student.setDob(dto.getDob());

	        List<Mark> markList = new ArrayList<>();
	        for (MarkDTO m : dto.getMarks()) {
	            if (m.getMark() < 0 || m.getMark() > 100) {
	                throw new IllegalArgumentException("Marks should be between 0 and 100");
	            }
	            Mark mark = new Mark();
	            mark.setSubject(m.getSubject());
	            mark.setMark(m.getMark());
	            mark.setStudent(student);
	            markList.add(mark);
	        }

	        student.setMarks(markList);
	        return studentRepo.save(student);
	    }

	    public List<Student> getAllStudents() {
	        List<Student> students = studentRepo.findAll();
	        for (Student student : students) {
	            double avg = student.getMarks().stream().mapToInt(Mark::getMark).average().orElse(0.0);
	            student.setAverageMark(avg);
	        }
	        return students;
	    }
	}