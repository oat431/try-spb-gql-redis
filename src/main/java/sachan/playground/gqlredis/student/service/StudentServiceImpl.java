package sachan.playground.gqlredis.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sachan.playground.gqlredis.student.dao.StudentDao;
import sachan.playground.gqlredis.student.entity.Student;
import sachan.playground.gqlredis.student.entity.StudentRequest;

@Service
//@CacheConfig(cacheNames = "studentCache")
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    @Override
    public Student createStudent(StudentRequest student) {
        Student checkIfExits = studentDao.getStudentById(student.getStudentId());
        if (checkIfExits != null) {
            return null;
        }
        Student newStudent = Student.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .studentId(student.getStudentId())
                .email(student.getEmail())
                .phone(student.getPhone())
                .build();
        return studentDao.saveStudent(newStudent);
    }

    @Override
//    @Cacheable(cacheNames = "StudentPage",key = "#pageRequest.pageNumber", unless = "#result == null")
    public Page<Student> getAllStudents(PageRequest pageRequest) {
        return studentDao.getAllStudents(pageRequest);
    }

    @Override
//    @Cacheable(cacheNames = "StudentId",key = "#id", unless = "#result == null")
    public Student getStudent(String id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public Student updateStudent(String id, StudentRequest student) {
        Student oldStudent = studentDao.getStudentById(id);
        if (oldStudent == null) {
            return null;
        }
        oldStudent.setFirstname(student.getFirstname());
        oldStudent.setLastname(student.getLastname());
        oldStudent.setStudentId(id);
        oldStudent.setEmail(student.getEmail());
        oldStudent.setPhone(student.getPhone());
        return studentDao.saveStudent(oldStudent);
    }

    @Override
    public Student deleteStudent(String id) {
        return studentDao.deleteStudent(id);
    }
}
