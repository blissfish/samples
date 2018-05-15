package circuit.breaker.sample;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MyService {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private final RestTemplate restTemplate;

	public MyService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(commandKey = "circuitBreaker", fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
	public String api() {
		URI uri = URI.create("http://localhost:8080/api");
		String result = "";
		try {
			log.info("Waiting for 3000ms before delegating to fallback...");
			result = this.restTemplate.getForObject(uri, String.class);
		} catch (Exception e) {
			log.error(" ... service didn't replyed!",e);
			throw new RuntimeException("InternalServerError - Try Fallback");
		}
		return result;
	}

	private String fallback() {
		return "Hello World Fallback!";
	}

}