package pl.waldi.RecruitmentProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class is for encoding the users passwords
 */
@Configuration

public class PasswordEncoder {
    /**
     * This method is setting the encoder to BCrypt encoder
     * @return returning encoder witch is used to encode the passwords
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}
