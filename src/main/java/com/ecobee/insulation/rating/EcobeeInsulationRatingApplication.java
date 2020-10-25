package com.ecobee.insulation.rating;

import com.ecobee.insulation.rating.service.RateCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EcobeeInsulationRatingApplication implements CommandLineRunner {

	@Autowired
	private RateCalculationService rateCalculationService;

	public static void main(String[] args) {
		SpringApplication.run(EcobeeInsulationRatingApplication.class,args);
	}


	@Override
	public void run(String... args) throws Exception {
		rateCalculationService.reportRate();
	}
}
