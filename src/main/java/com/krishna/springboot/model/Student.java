package com.krishna.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students_Details")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String course;
	@Column(nullable = false, length = 50)
	private String collegeName;
	
	
	
	public Student() {
		super();
		
	}



	public Student(long id, String name, String course, String collegeName) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.collegeName = collegeName;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCourse() {
		return course;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", collegeName=" + collegeName + "]";
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public String getCollegeName() {
		return collegeName;
	}



	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	
	
	
	
	
	

}