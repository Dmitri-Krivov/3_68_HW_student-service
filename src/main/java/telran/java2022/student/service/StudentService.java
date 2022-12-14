package telran.java2022.student.service;

import java.util.ArrayList;
import java.util.List;

import telran.java2022.student.dto.ScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;

public interface StudentService {
	Boolean addStudent(StudentCreateDto studentCreateDto);

	StudentDto findStudent(Integer id);

	StudentDto removeStudent(Integer id);

	StudentCreateDto updateStudent(Integer id, StudentUpdateDto studentUpdateDto);

	Boolean addScore(Integer id, ScoreDto scoreDto);

	List<StudentDto> findStudentByName(String name);

	Integer getStudentsNameQuantity(ArrayList<String> nameOfStudents);

	List<StudentDto> getStudentsByExamScore(String exam, int minScore);

}
