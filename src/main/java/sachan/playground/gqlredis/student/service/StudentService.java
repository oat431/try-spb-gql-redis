package sachan.playground.gqlredis.student.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sachan.playground.gqlredis.student.entity.Student;
import sachan.playground.gqlredis.student.entity.StudentRequest;

public interface StudentService {
    Student createStudent(StudentRequest student);
    Page<Student> getAllStudents(PageRequest pageRequest);
    Student getStudent(String id);
    Student updateStudent(String id, StudentRequest student);
    Student deleteStudent(String id);
}
