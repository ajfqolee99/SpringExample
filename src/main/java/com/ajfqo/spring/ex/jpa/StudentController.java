package com.ajfqo.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajfqo.spring.ex.jpa.domain.Student;
import com.ajfqo.spring.ex.jpa.repository.StudentRepository;
import com.ajfqo.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// Controller에서는  Repository 객체사용 금지
	// 편의를 위해 잠시 사용
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/selete")
	@ResponseBody
	public List<Student> selectStudent() {
		
		// 모든행 조회
//		List<Student> studentList = studentRepository.findAll();
		
//		List<Student> studentList = studentRepository.findAllByOrderByIdDesc();
		
//		List<Student> studentList = studentRepository.findTOP1ByOrderByIdDESC();
		
//		List<Student> studentList = studentRepository.findByName("조세호");
		
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("조세호");
//		List<Student> studentList = studentRepository.findByNameIn(null);
		
//		List<Student> studentList = studentRepository.findByEmailContaining("naver");
		
//		List<Student> studentList = studentRepository.findByIdBetweenOrderByDesc(1, 7);
		
		List<Student> studentList = studentRepository.findByDreamJobQuery("모델");
		return studentList;
		
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		
		// 이하영, 010-1234-5678, aaaa@naver.com, 개발자
		Student student = studentService.addStudent("이하영", "010-1234-5678", "aaaa@naver.com", "개발자");
		
		return student;
	}
	
	// id가 3인 학생정보의 장래희망을 강사로 변경
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		Student student = studentService.updateStudent(3, "강사");
		return student;
	}
	
	// id가 3인 학생정보를 삭제
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		studentService.deleteStudent(3);
		return "삭제 성공";
	}
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		
//		생성자를 사용한 방식	
//		Student student = new Student(0, "이하영", "010-1234-5678", "asdf@naver.com", "개발자", null, null);
//		Setter를 사용한 방식
//		student.setName("이하영");
//		student.setDreamJob("개발자");
//		student.setPhoneNumber("010-1234-5678");
//		student.setEmail("asdf@naver.com");
		
//		builder pattern을 사용한 방식
		Student student = Student.builder()
								.name("이하영")
								.dreamJob("개발자")
								.phoneNumber("010-1234-5678")
								.email("asdf@naver.com")
								.build();		
		return student;
	}
	
	
}
