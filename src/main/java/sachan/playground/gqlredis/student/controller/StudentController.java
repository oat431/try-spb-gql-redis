package sachan.playground.gqlredis.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import sachan.playground.gqlredis.student.dto.PageStudentDto;
import sachan.playground.gqlredis.student.dto.StudentDto;
import sachan.playground.gqlredis.student.entity.Student;
import sachan.playground.gqlredis.student.entity.StudentRequest;
import sachan.playground.gqlredis.student.service.StudentService;
import sachan.playground.gqlredis.utils.GqlRedisMapper;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;

    @QueryMapping
    public StudentDto getStudentById(@Argument String id) {
        return GqlRedisMapper.INSTANCE.getStudentDto(studentService.getStudent(id));
    }

    @QueryMapping
    public PageStudentDto getAllStudents(@Argument Integer page, @Argument Integer size) {
        int p = page == null ? 1 : page;
        int s = size == null ? 10 : size;
        PageRequest pageRequest = PageRequest.of(p-1, s);
        Page<Student> studentPage = studentService.getAllStudents(pageRequest);
        return PageStudentDto.builder()
                .number(p)
                .totalPages(studentPage.getTotalPages())
                .totalElements((int) studentPage.getTotalElements())
                .content(GqlRedisMapper.INSTANCE.getStudentDto(studentPage.getContent()))
                .build();
    }

    @MutationMapping
    public StudentDto createStudent(@Argument StudentRequest student) {
        Student newStudent = studentService.createStudent(student);
        return GqlRedisMapper.INSTANCE.getStudentDto(newStudent);
    }

    @MutationMapping
    public StudentDto updateStudent(@Argument String id,@Argument StudentRequest student) {
        Student newStudent = studentService.updateStudent(id, student);
        return GqlRedisMapper.INSTANCE.getStudentDto(newStudent);
    }

    @MutationMapping
    public StudentDto deleteStudent(@Argument String id) {
        return GqlRedisMapper.INSTANCE.getStudentDto(studentService.deleteStudent(id));
    }

}


