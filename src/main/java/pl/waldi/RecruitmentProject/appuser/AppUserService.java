package pl.waldi.RecruitmentProject.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.waldi.RecruitmentProject.registration.token.ConfirmationToken;
import pl.waldi.RecruitmentProject.registration.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class is for finding the user during logging in
 */

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with email %s not found :(";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    /**
     * This method is for
     * @param email users email adress
     * @return returning the user
     * @throws UsernameNotFoundException the exception that that handle the situation
     * when username is not found in database, like it`s not registered yet
     */
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, email)));
    }

    /**
     *This method is for email handling
     * @param appUser certain user
     * @return returning token after succesful confirmation of email adress
     */
    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException("Hmmm... The email adres is already taken O.o");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );


        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    /**
     * This method adding the user email into the database of registered users
     * @param email users email
     * @return returning validated users email
     */
        public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
