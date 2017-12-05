package io.corbs.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static User EMPTY = new User();
    @Id
    private Long id;
    @Indexed
    private String login;
    private String password;
    @Indexed
    private String firstName;
    @Indexed
    private String lastName;
    private String email;
}
