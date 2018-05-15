package hello.world;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Application {
	  
	@Value("${version}")
	private String version;
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private final AtomicLong counter = new AtomicLong();
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@GetMapping(value = "/api")
	public Message echo() {
		return echo("Hello World!");
	}
	
	@GetMapping(value = "/api/{message}")
	public Message echo(@PathVariable String message) {
		Message data = new Message(counter.incrementAndGet(), message, version);
		log.info(data.toString());
		return data;
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
    
}
