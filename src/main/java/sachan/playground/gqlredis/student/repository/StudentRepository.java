package sachan.playground.gqlredis.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sachan.playground.gqlredis.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(String studentId);
}
