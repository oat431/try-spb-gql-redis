package sachan.playground.gqlredis.student.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sachan.playground.gqlredis.student.entity.Student;

public interface StudentDao {

    Page<Student> getAllStudents(PageRequest pageRequest);
    Student getStudentById(String id);
    Student saveStudent(Student student);
    Student deleteStudent(String id);
}
