package circuit.breaker.sample;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyService {

	private final RestTemplate restTemplate;

	public MyService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "fallback")
	public String api() {
		URI uri = URI.create("http://localhost:8080/api");
		return this.restTemplate.getForObject(uri, String.class);
	}

	private String fallback() {
		return "Hello World Fallback!";
	}

}