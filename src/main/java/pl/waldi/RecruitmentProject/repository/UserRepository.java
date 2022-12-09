package pl.waldi.RecruitmentProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.waldi.RecruitmentProject.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select p from PERSON p")
    List<User> findAll();
}
