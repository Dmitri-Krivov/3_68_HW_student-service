package telran.java2022.student.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import telran.java2022.student.dto.StudentDto;
import telran.java2022.student.model.Student;
@Component
public class StudentRepositoryImpl implements StudentRepository {
	Map<Integer, Student> students = new ConcurrentHashMap<>();

	@Override
	public Student save(Student student) {
		students.put(student.getId(), student);
		return student;
	}

	@Override
	public Optional<Student> findById(int id) {
		return Optional.ofNullable(students.get(id));
	}

	@Override
	public void deleteById(int id) {
		students.remove(id);
	}
	
	@Override
	public List<StudentDto> findByName(String name) {
		List <StudentDto> sDtos = new ArrayList<>();
		for(Map.Entry<Integer, Student> studs: students.entrySet()) {
			if(studs.getValue().getName().equals(name)) {
				StudentDto studentDto = new StudentDto(studs.getValue().getId(),studs.getValue().getName(),studs.getValue().getScores());
				sDtos.add( studentDto);
			}
		}
		return sDtos;
	}

	@Override
	public List<StudentDto> getStudentsByExamMinScore(String exam, int minScore) {
		List <StudentDto> sDtos = new ArrayList<>();
		for(Map.Entry<Integer, Student> studs: students.entrySet()) {
			if(studs.getValue().getScores().containsKey(exam)&&studs.getValue().getScores().get(exam)>=minScore) {
				StudentDto studentDto = new StudentDto(studs.getValue().getId(),studs.getValue().getName(),studs.getValue().getScores());
				sDtos.add(studentDto);
			}
		}
		return sDtos;		
	}

}
