package efub.toyproject.tweeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TweeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweeterApplication.class, args);
	}

}
