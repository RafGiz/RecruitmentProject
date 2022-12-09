package pl.waldi.RecruitmentProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.waldi.RecruitmentProject.entity.User;
import pl.waldi.RecruitmentProject.repository.UserRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;

    }

}
