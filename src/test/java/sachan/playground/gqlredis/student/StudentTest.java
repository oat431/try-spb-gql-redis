package sachan.playground.gqlredis.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sachan.playground.gqlredis.configs.RedisConfig;
import sachan.playground.gqlredis.student.entity.Student;
import sachan.playground.gqlredis.student.repository.StudentRepository;

@SpringBootTest
public class StudentTest {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RedisConfig redisConfig;

    // create fake first name for 20 student
    String[] firstnames = {
            "John", "Paul", "George", "Ringo", "Pete", "Stuart", "Mick", "Keith", "Ronnie", "Charlie",
            "Brian", "Roger", "John", "Paul", "George", "Ringo", "Pete", "Stuart", "Mick", "Keith"
    };

    // create fake last name for 20 student
    String[] lastnames = {
            "Lennon", "McCartney", "Harrison", "Starr", "Townshend", "Sutcliffe", "Jagger", "Richards", "Wood", "Watts",
            "Jones", "Daltrey", "Bonham", "Plant", "Page", "Plant", "Townshend", "Sutcliffe", "Jagger", "Richards"
    };

    // create fake id for 20 student
    String[] fake_id = {
            "62201", "62202", "62203", "62204", "62205", "62206", "62207", "62208", "62209", "62210",
            "62211", "62212", "62213", "62214", "62215", "62216", "62217", "62218", "62219", "62220"
    };

    @Test
    void loadStudent() {
        for(int i=0; i<20; i++) {
            Student student = Student.builder()
                    .firstname(firstnames[i])
                    .lastname(lastnames[i])
                    .studentId(fake_id[i])
                    .email(firstnames[i] + "@" + lastnames[i] + ".com")
                    .phone("0"+fake_id[i]+""+fake_id[i]+""+(i%10))
                    .build();
            studentRepository.save(student);
        }
    }
}
