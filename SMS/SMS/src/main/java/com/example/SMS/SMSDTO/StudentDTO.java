package com.example.SMS.SMSDTO;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
	  private String name;
	    private LocalDate dob;
	    private List<MarkDTO> marks;
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
		public List<MarkDTO> getMarks() {
			return marks;
		}
		public void setMarks(List<MarkDTO> marks) {
			this.marks = marks;
		}

}
