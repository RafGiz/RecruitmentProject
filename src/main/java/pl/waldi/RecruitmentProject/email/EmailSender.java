package pl.waldi.RecruitmentProject.email;

/**
 * This class is fo sending an email
 */
public interface EmailSender {
    /**
     * @param to user
     * @param email users email adress
     */
    void send(String to, String email);

}
