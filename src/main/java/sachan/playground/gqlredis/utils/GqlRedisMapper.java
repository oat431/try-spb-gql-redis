package sachan.playground.gqlredis.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sachan.playground.gqlredis.student.dto.StudentDto;
import sachan.playground.gqlredis.student.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface GqlRedisMapper {
    GqlRedisMapper INSTANCE = Mappers.getMapper(GqlRedisMapper.class);

    StudentDto getStudentDto(Student student);
    List<StudentDto> getStudentDto(List<Student> student);
}
