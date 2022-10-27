package telran.java2022.student.controller;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;
import telran.java2022.student.service.StudentService;

@RestController
public class StudentController {
	StudentService studentService;

	@PostMapping("/student")
	public Boolean addStudent(@RequestBody StudentCreateDto studentCreateDto) {
		return studentService.addStudent(studentCreateDto);
	}

	@GetMapping("/student/{id}")
	public StudentDto findStudent(@PathVariable Integer id) {
		return studentService.findStudent(id);
	}

	@DeleteMapping("/student/{id}")
	public StudentDto deleteStudent(@PathVariable Integer id) {
		return studentService.removeStudent(id);
	}

	@PutMapping("/student/{id}")
	public StudentCreateDto updateStudent(@PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto) {
		return studentService.updateStudent(id, studentUpdateDto);
	}

	@PutMapping("/student/{id}")
	public Boolean studentUpdateScore(@PathVariable Integer id, @RequestParam String exam, @RequestParam int score) {
		return studentService.studentUpdateScore(id, exam, score);

	}

	@GetMapping("/student/name/{name}")
	public ArrayList<StudentDto> findStudentByNameByName(@PathVariable String name) {
		return studentService.findStudentByName(name);
	}

	@PostMapping("/quantity/students")
	public Integer studentsQuantity(@RequestBody ArrayList<String> nameOfStudents) {
		return studentService.studentsQuantity(nameOfStudents);
	}

	@GetMapping("/student/exam/{exam}/minscore/{minScore}")
	public ArrayList<StudentDto> findStudentByMinScore(@PathVariable String exam, @PathVariable int minScore) {
		return studentService.findStudentByMinScore(exam, minScore);
	}

}
