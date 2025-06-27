package com.example.SMS.SMSEntity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Student {
	
	 @Id @GeneratedValue
	    private Long id;
	    private String name;
	    private LocalDate dob;

	    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private List<Mark> marks;

	    @Transient
	    private Double averageMark;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public List<Mark> getMarks() {
			return marks;
		}

		public void setMarks(List<Mark> marks) {
			this.marks = marks;
		}

		public Double getAverageMark() {
			return averageMark;
		}

		public void setAverageMark(Double averageMark) {
			this.averageMark = averageMark;
		}

}
