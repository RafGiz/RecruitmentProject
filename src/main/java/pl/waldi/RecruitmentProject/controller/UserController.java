package pl.waldi.RecruitmentProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.waldi.RecruitmentProject.entity.User;
import pl.waldi.RecruitmentProject.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
/**
 * This class is for controlling base of users
 */

public class UserController {


    private final UserService userService;

    /**
     * Method allows to list all the users
     * @return the total amount of users
     */

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);

    }

}
