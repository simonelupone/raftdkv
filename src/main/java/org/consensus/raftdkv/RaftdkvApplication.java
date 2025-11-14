package org.consensus.raftdkv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring documentation
 * 
 * @Configuration - is a class-level annotation indicating that an object is a
 *                source of bean definitions
 * @EnableScheduling - enable scheduling in the application.
 */
@EnableScheduling
@SpringBootApplication
public class RaftdkvApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaftdkvApplication.class, args);
	}

}
