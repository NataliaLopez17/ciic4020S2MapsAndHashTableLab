package ciic4020.student;

import ciic4020.map.KeyExtractor;

public class StudentKeyExtractor implements KeyExtractor<String, Student> {

	@Override
	public String getKey(Student student) {
		return student.getStdId();
	}

}