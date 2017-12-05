package io.corbs.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
}
