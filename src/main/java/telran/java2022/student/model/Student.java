package telran.java2022.student.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.java2022.student.dto.StudentDto.StudentDtoBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

@EqualsAndHashCode(of = "id")
public class Student {
	int id;
	@Setter
	String name;
	@Setter
	String password;
	Map<String, Integer> scores;
	public Student(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		scores = new HashMap<>();
	}
	
	public boolean addScore(String exam, int score) {
		return scores.put(exam, score)==null;
	}


	
}
