package telran.java2022.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.java2022.student.dao.StudentRepository;
import telran.java2022.student.dto.ScoreDto;
import telran.java2022.student.dto.StudentCreateDto;
import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.dto.StudentUpdateDto;
import telran.java2022.student.model.Student;

@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Boolean addStudent(StudentCreateDto studentCreateDto) {
		if (studentRepository.findById(studentCreateDto.getId()).isPresent()) {
			return false;
		}
		Student student = new Student(studentCreateDto.getId(), studentCreateDto.getName(),
				studentCreateDto.getPassword());
		studentRepository.save(student);
		return true;
	}

	@Override
	public StudentDto findStudent(Integer id) {
		Student student = studentRepository.findById(id).orElse(null);
		if (student == null) {
			return null;
		}
		return StudentDto.builder()
				.id(student.getId())
				.name(student.getName())
				.scores(student.getScores())
				.build();
	}

	@Override
	public StudentDto removeStudent(Integer id) {
		Student student = studentRepository.findById(id).orElse(null);
		if (student == null) {
			return null;
		}
		studentRepository.deleteById(id);
		return StudentDto.builder()
				.id(student.getId())
				.name(student.getName())
				.scores(student.getScores())
				.build();
	}

	@Override
	public StudentCreateDto updateStudent(Integer id, StudentUpdateDto studentUpdateDto) {
		Student student = studentRepository.findById(id).orElse(null);
		if (student == null) {
			return null;
		}
		studentRepository.save( Student.builder()
				.id(student.getId())
				.name(studentUpdateDto.getName())
				.password(studentUpdateDto.getPassword())
				.scores(student.getScores()).build());
		
		return StudentCreateDto.builder()
				.id(student.getId())
				.name(studentUpdateDto.getName())
				.password(studentUpdateDto.getPassword())
				.build();
	}

	@Override
	public Boolean addScore(Integer id, ScoreDto scoreDto) {
		Student student = studentRepository.findById(id).orElse(null);
		if (student == null) {
			return null;
		}
		return student.addScore(scoreDto.getExamName(), scoreDto.getScore());
	}

	@Override
	public List<StudentDto> findStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public Integer getStudentsNameQuantity(ArrayList<String> nameOfStudents) {
		Integer sum = 0;
	for (int i = 0; i < nameOfStudents.size(); i++) {
		sum += studentRepository.findByName(nameOfStudents.get(i)).size();
	}
		return sum;
	}

	@Override
	public List<StudentDto> getStudentsByExamScore(String exam, int minScore) {
		return studentRepository.getStudentsByExamMinScore(exam, minScore);
	}

}
