package com.krishna.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.krishna.springboot.dao.StudentRepository;
import com.krishna.springboot.model.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class StudentTests {
	
	@Autowired
	
	StudentRepository studentRepository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void addStudent() {
		Student student=new Student(1,"krishna","mca","LNCT");
		Student savedStudent= studentRepository.save(student);
		
		assertNotNull(savedStudent);
	}
	
	
	@Test
	@Order(2)
	public void findStudentByName()
	{
		String name= "krishna";
		Student student = studentRepository.findStudentByName(name);
		
		assertThat(student.getName()).isEqualTo(name);
		
	}
	
	
	@Test
	@Rollback(false)
	@Order(3)
	public void updateStudent()
	{
		String studentName="Deepak";
		Student student=new Student(0, studentName, "ECC", "OIST");
		student.setId(1);
		
		studentRepository.save(student);
		
		Student updatedStudent=studentRepository.findStudentByName(studentName);
		assertThat(updatedStudent.getName()).isEqualTo(studentName);
	}
	
	
	@Test
	@Order(4)
	public void listStudent()
	{
		List<Student> students=(List<Student>) studentRepository.findAll();
		
		for(Student student :students)
		{
			System.out.println(student);
		}
		assertThat(students).size().isGreaterThan(0);
	}
	
	
	@Test
	@Rollback(false)
	@Order(5)
	public void studentDelete() {
		
		
		long id=6;
		boolean isExistBeforeDelete=studentRepository.findById(id).isPresent();
		studentRepository.deleteById(id);
		boolean notExistAfterDelete=studentRepository.findById(id).isPresent();
		
		assertTrue(isExistBeforeDelete);
		assertFalse(notExistAfterDelete);
	}
	
	
	
	
}
