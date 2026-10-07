package samt.loraterra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samt.loraterra.data.UserRepository;
import samt.loraterra.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class MainPageUserService {
    private final UserRepository userRepository;
    @Autowired
    public MainPageUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {
        return userRepository.findByRoleNameNot("Admin");
    }

    public User findUserByUsername(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }

}
