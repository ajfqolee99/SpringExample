package com.ajfqo.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqo.spring.ex.jpa.domain.Student;
import com.ajfqo.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		Student student = Student.builder()
//				.name("이하영") 전달받을 파라미터 값으로 추가할 것이기 때문에 값을 지정해주는것이 아닌 전달받은 파라미터명을 넣어준다.
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		
		student = studentRepository.save(student);
		return student;
	}
	
	// 특정 id의 학생정보중 전달된 장래희망으로 수정하는 기능
	public Student updateStudent(int id, String dreamJob) {
		// update 대상을 조회한다.
		// 조회된 객체에서 수정사항을 적용한다.
		// 해당 객체를 저장한다.
		
		// Optional
		// null일수도 있는 객체를 리턴할때 쓰이는 클래스
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder().dreamJob(dreamJob).build();
		
		student = studentRepository.save(student);
		
		return student;
	}
	
	public void deleteStudent(int id) {
		// 삭제대상을 조회한다.
		// 조회된 객체를 통해 삭제한다.
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
	}
	
}
