package sachan.playground.gqlredis.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageStudentDto {
    Integer number;
    Integer totalPages;
    Integer totalElements;
    List<StudentDto> content;
}
