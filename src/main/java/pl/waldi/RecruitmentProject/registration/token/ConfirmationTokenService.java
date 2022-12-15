package pl.waldi.RecruitmentProject.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * This class is for confirmation of the token, storing into database and saving them
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    /**
     * This method save the confirmation token
     * @param token token which was sent to user
     */
    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);

    }

    /**
     * This method is
     * @param token token which was sent to user
     * @return
     */
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    /**
     * This method
     * @param token
     * @return
     */
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
