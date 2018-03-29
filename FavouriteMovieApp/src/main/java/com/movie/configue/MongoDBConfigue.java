package com.movie.configue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.movie.repository.FavouriteMovieRepository;
import com.movie.repository.UserRepository;


@EnableMongoRepositories(basePackages ="com.movie.repository")
@Configuration
public class MongoDBConfigue {
	 @Bean
	    CommandLineRunner commandLineRunner(FavouriteMovieRepository movieRepository,UserRepository userRepository) {
	        return null;
	    }
}
