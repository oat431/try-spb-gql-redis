package sachan.playground.gqlredis.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    String firstname;
    String lastname;
    String studentId;
    String email;
    String phone;
}
