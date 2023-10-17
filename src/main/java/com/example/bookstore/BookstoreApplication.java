package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1= new Book("Pupen tarinat", "Pertti Maki", 2014,"10908363839272", 13 );
			Book b2=new Book("Jaskan tarinat", "Jaska Maki", 2003, "1516818616484", 15) ;
			Book b3=new Book("Timon tarinat", "Timo Maki", 2020, "351161686518", 22);
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
