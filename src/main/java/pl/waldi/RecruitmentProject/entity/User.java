package pl.waldi.RecruitmentProject.entity;

import lombok.*;

import javax.persistence.*;

/**
 * This class is for defining user by his id, name, password and email adress
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PERSON")
@Table
public class User {

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "emailAdress")
    private String emailAdress;
}

