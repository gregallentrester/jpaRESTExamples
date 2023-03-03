package com.example.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demo(VendorRepository repo) {
		return (args) -> {

			repo.save(new Vendor("APPLE", "M2"));
			repo.save(new Vendor("INTEL", "ALPHA"));
			repo.save(new Vendor("INTEL", "H4"));


			System.err.println(YLW + "\n\t     ...  ...  ..." + NC);

			System.err.println(GRN + "\nfindAll()" + NC);
			for (Vendor vendor : repo.findAll()) {
				System.err.println(vendor + "");
			}

			System.err.println(GRN + "\n\nfindById(1L)" + NC);
			Vendor vendor = repo.findById(1L);
			System.err.println(vendor);


			System.err.println(
				GRN + "\n\nVendor found with findByProduct('M2')" + NC);

			repo.findByProduct("M2").forEach(any -> {
				System.err.println(any.toString());
			});

			System.err.println(
				GRN + "\n\nVendor found with findByProduct('ALPHA')" + NC);

			for (Vendor any : repo.findByProduct("ALPHA")) {
			 	System.err.println(any.toString());
		  }

			System.err.println(YLW + "\n\t     ...  ...  ...\n" + NC);
		};
	}

	public static final String NC = "\u001B[0m";
	public static final String GRN = "\u001B[32m";
	public static final String YLW = "\033[1;93m";
}
