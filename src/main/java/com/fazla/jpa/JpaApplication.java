package com.fazla.jpa;

import com.fazla.jpa.models.Author;
import com.fazla.jpa.models.Video;
import com.fazla.jpa.repositories.AuthorRepository;
import com.fazla.jpa.repositories.VideoRepository;
import com.fazla.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

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
//			Specification<Author> spec = Specification.
//					where(AuthorSpecification.hasAge(32))
//					.and(AuthorSpecification.firstNameLike("%La%"));
//
//			authorRepository.findAll(spec).forEach(System.out::println);

//			Author author = Author.builder()
//					.id(1)
//					.firstName("fazla")
//					.lastName("rabbi")
//					.age(26)
//					.email("abc@gmail.com")
//					.build();
//			authorRepository.save(author);

//			authorRepository.updateAuthor(32,1);
//			authorRepository.updateAllAuthorsAges(52);
			//find by named query
//			List<Author> authors = authorRepository.findByNamedQuery(50);
//			System.out.println(authors);
//
//			//Update with named query
//			authorRepository.updateByNamedQuery(67);


			Faker faker = new Faker();
			for (int i=0;i<10;i++){
				Author author = Author.builder()
					.firstName(faker.name().firstName())
					.lastName(faker.name().lastName())
					.age(faker.number().numberBetween(19,100))
					.email("abc"+ i +"@gmail.com")
					.build();
				authorRepository.save(author);
			}

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
