package pl.waldi.RecruitmentProject.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * This class is for controller of registration process
 */
@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    /**
     * Method that
     * @param request
     * @return
     */
    @PostMapping(path = "register")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);

    }
    /**
     * Method
     * @param token
     * @return
     */
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {

        return registrationService.confirmToken(token);
    }
}
