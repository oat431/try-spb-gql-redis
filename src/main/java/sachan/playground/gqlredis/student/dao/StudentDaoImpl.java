package sachan.playground.gqlredis.student.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import sachan.playground.gqlredis.student.entity.Student;
import sachan.playground.gqlredis.student.repository.StudentRepository;

@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    final StudentRepository studentRepository;

    @Override
    public Page<Student> getAllStudents(PageRequest pageRequest) {
        return studentRepository.findAll(pageRequest);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findByStudentId(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(String id) {
        Student student = studentRepository.findByStudentId(id);
        if (student != null) {
            studentRepository.delete(student);
        }
        return student;
    }
}
