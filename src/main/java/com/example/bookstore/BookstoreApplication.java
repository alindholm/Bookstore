package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Gategory;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.GategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, GategoryRepository grepository) {
		return (args) -> {
			
			log.info("save a couple of students");
			grepository.save(new Gategory("Novel"));
			grepository.save(new Gategory("Fiction"));
			grepository.save(new Gategory("Children"));
			
			Book b1= new Book("Pupen tarinat", "Pertti Maki", 2014,"10908363839272", 13, grepository.findByName("Children").get(0) );
			Book b2=new Book("Jaskan tarinat", "Jaska Maki", 2003, "1516818616484", 15, grepository.findByName("Novel").get(0)) ;
			Book b3=new Book("Timon tarinat", "Timo Maki", 2020, "351161686518", 22, grepository.findByName("Fiction").get(0));
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
