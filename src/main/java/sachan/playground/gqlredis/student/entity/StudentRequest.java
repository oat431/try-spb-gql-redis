package sachan.playground.gqlredis.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    String firstname;
    String lastname;
    String studentId;
    String email;
    String phone;
}
