package br.com.or.sigeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SigebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigebApplication.class, args);
	}

}
