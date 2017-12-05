package io.corbs.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	private UserRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		for(int i = 0; i < 10; i++) {
			User user = new User();
			String firstName = Randomness.getFirstName();
			String lastName = Randomness.getLastName();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword(Randomness.getRandomPassword());
			user.setEmail(Randomness.getEmailAddress(firstName + "." + lastName));
			user.setLogin(user.getEmail());
			this.repo.save(user);
		}

	}
}
