package telran.java2022.student.service;

import java.util.ArrayList;

import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;

public interface StudentService {
	Boolean addStudent(StudentCreateDto studentCreateDto);

	StudentDto findStudent(Integer id);

	StudentDto removeStudent(Integer id);

	StudentCreateDto updateStudent(Integer id, StudentUpdateDto studentUpdateDto);

	Boolean studentUpdateScore(Integer id, String exam, int score);

	ArrayList<StudentDto> findStudentByName(String name);

	Integer studentsQuantity(ArrayList<String> nameOfStudents);

	ArrayList<StudentDto> findStudentByMinScore(String exam, int minScore);

}
