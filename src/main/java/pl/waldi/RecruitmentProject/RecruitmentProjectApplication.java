package pl.waldi.RecruitmentProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This class is main class of the project
 */
@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class RecruitmentProjectApplication {

	/**
	 * This method is for start the whole application
	 */
	public static void main(String[] args) {
		SpringApplication.run(RecruitmentProjectApplication.class, args);
	}

}
