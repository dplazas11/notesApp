package co.edu.poli.notesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("co.edu.poli.notesApp.modelo")
@ComponentScan("co.edu.poli.notesApp")
@EnableJpaRepositories("co.edu.poli.notesApp.repositorio")
@SpringBootApplication
public class NotesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesAppApplication.class, args);
                
	}

}
