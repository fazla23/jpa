package com.fazla.jpa;

import com.fazla.jpa.models.Author;
import com.fazla.jpa.models.Video;
import com.fazla.jpa.repositories.AuthorRepository;
import com.fazla.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
		AuthorRepository authorRepository,
		VideoRepository videoRepository
	){
		return args -> {
//			Author author = Author.builder()
//					.firstName("fazla")
//					.lastName("rabbi")
//					.age(26)
//					.email("abc@gmail.com")
//					.build();
//			authorRepository.save(author);
//			Video video = Video.builder()
//					.length(5)
//					.name("abc")
//					.build();
//			videoRepository.save(video);
		};
	}

}
