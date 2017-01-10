package cn.lhfei.cloud.notebook.client;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class NotebookAppClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotebookAppClientApplication.class, args);
	}
	
	
	@GetMapping("/notebooks/")
	public @ResponseBody String list(Map<String, Object> model) {
		
		return client.list(model);
	}
	
	@GetMapping("/id")
	public String generateId(){
		return client.generatedId();
	}

	
	@FeignClient("Notebook")
	interface NotebookClient {
		@RequestMapping(value = "/notebook/notebooks/", method = GET)
		String list(Map<String, Object> model);
		
		@RequestMapping(value = "/notebook/id", method = GET)
		String generatedId();

	}
	
	@Autowired
	NotebookClient client;
	
	
}
