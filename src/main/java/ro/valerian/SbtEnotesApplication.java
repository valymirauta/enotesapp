package ro.valerian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class SbtEnotesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SbtEnotesApplication.class, args);
	}

}
