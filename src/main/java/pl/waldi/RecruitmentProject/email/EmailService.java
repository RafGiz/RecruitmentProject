package pl.waldi.RecruitmentProject.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * This class is for handling email service so user can confirm an email which
 * was send after registration process
 */
@Service
@AllArgsConstructor
public class EmailService implements EmailSender{


    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    /**
     * This method is for sending a mime message to user
     * @param to user
     * @param email users email adress
     * User gets an email with confirmation, if email is incorrect, there is exception
     */
    @Override
    @Async
    public void send(String to, String email) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("hello@somegmejl.com");
            mailSender.send(mimeMessage);


        } catch (MessagingException e) {
            LOGGER.error("failed to send email :(", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
