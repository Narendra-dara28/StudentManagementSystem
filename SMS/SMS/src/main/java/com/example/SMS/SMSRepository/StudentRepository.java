package com.example.SMS.SMSRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SMS.SMSEntity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
