package crud.CrudHexagonal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"crud.CrudHexagonal.content.persona.infrastucture.controller",
		"crud.CrudHexagonal.content.persona.application",
		"crud.CrudHexagonal.content.persona.infrastucture.repository.jpa"
})

@EnableJpaRepositories(basePackages = {"crud.CrudHexagonal.content.persona.infrastucture.repository.jpa"})

@EntityScan("crud.CrudHexagonal.content.persona.domain")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
