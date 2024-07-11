package learn.ram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/prod")
public class Testcontroller {
	
//	@Autowired
//	RestTemplate rt;
//	
	
	@GetMapping("/data")
	public String getinfo() {
		return "Hello Ram";
	}

}
