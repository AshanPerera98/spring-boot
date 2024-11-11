package com.ashan_perera.content_calendar;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ashan_perera.content_calendar.model.Content;
import com.ashan_perera.content_calendar.model.Status;
import com.ashan_perera.content_calendar.model.Type;
import com.ashan_perera.content_calendar.repository.ContentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// this bean will run after server is initialized and before start listning to the port
	// any component that is used inside the runner needs to be passed as arguments
	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository){
		return args -> {
			System.out.println("Data insertion started...");
			
			Content content = new Content(
				null, 
				"This content is generated by runner", 
				"This will be injected in the runtime", 
				Status.IN_PROGRESS, 
				Type.PODCAST, 
				LocalDateTime.now(), 
				null, 
				null
			);

			contentRepository.save(content);
		};
	}

}
