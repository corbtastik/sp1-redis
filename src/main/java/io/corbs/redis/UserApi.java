package io.corbs.redis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApi {

    private final UserRepo repo;

    @Autowired
    public UserApi(UserRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return this.repo.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        this.repo.findAll().forEach(users::add);
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return this.repo.findOne(id);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return this.repo.save(user);
    }

    @DeleteMapping("/users/{id}")
    public User removeUser(@PathVariable String id) {
        User user = this.repo.findOne(id);
        if(user != null) {
            this.repo.delete(user);
            return user;
        }
        return User.EMPTY;
    }
}
