package io.letsTalk.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TalkApiApp {

//stand-alone main method that ensures the application runs with a single click	
	public static void main(String[] args) {
		SpringApplication.run(TalkApiApp.class, args);
	}

}
