package sachan.playground.gqlredis.student.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@Entity
//@RedisHash("Student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    String firstname;
    String lastname;
    String studentId;
    String email;
    String phone;

}
