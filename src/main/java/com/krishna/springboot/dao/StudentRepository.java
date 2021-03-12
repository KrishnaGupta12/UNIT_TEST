package com.krishna.springboot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

	

	public Student findStudentByName(String name);

	public Optional<Student> findById(Integer id);
	
	


}
