package de.bmw.aw.storagebinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StorageBinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageBinServiceApplication.class, args);
	}
}
