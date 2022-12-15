package pl.waldi.RecruitmentProject.registration.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.waldi.RecruitmentProject.appuser.AppUser;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * This class is for storing the confirmation token in the database, generating and handling them to users
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn (
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;

    /**
     * This method provide validation of user which was subscribed to token
     * @param token user confirmation token
     * @param createdAt time which token is created
     * @param expiredAt time which token will expire
     * @param appUser user
     */
    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiredAt,
                             AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiredAt;
        this.appUser = appUser;
    }
}
