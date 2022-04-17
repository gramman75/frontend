package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class CoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
