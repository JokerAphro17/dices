package com.game.dice.seeders;

import com.game.dice.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.game.dice.repositories.UserRepository;
import java.util.List;

@Component
public class UserSeeder  implements CommandLineRunner{
    private final UserRepository userRepository;

    public UserSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        // users list
        List<User> users = List.of(
                new User("John", "Doe", "jo@m.com", "123456", "1234567890", "123 Main St"),
                new User("Sasuke", "Uchiha", "sasuke@uchiha", "123456", "1234567890", "123 Main St"),
                new User("Naruto", "Uzumaki", "naruto@uzumaki", "123456", "1234567890", "123 Main St"),
                new User("Sakura", "Haruno", "sakura@haruno", "123456", "1234567890", "123 Main St")
                );

        // save users to database

        for (User user : users) {
            User newUser = new User(user.getLast_name(), user.getFirst_name(), user.getEmail(), user.getPassword(), user.getPhone_number(), user.getAddress());
            userRepository.save(newUser);
        }
    }
}
