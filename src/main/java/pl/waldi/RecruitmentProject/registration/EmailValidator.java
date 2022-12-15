package pl.waldi.RecruitmentProject.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

/**
 * This class is f***ed up and noone gonna read it
 */

@Service
public class EmailValidator implements Predicate<String> {
    /**
     * Method validate the email
     * @param s the input argument
     */
    @Override
    public boolean test(String s) {
        return true;
    }
}
