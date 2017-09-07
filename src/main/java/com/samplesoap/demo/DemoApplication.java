package com.samplesoap.demo;

import hello.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CountriesClient countriesClient) {
		return args -> {
			String countryName = "Spain";
			if ( args.length > 0 ) {
				countryName = args[0];
			}

			GetCountryResponse response = countriesClient.getCountryResponse(countryName);

			System.err.println(response.getCountry().getName());
		};
	}

}
