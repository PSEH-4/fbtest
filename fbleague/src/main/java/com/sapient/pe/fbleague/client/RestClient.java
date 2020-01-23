package com.sapient.pe.fbleague.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {
/*	
	@Autowired
	private RestTemplate restTemplate;*/
	
	public String getResponse(final String url){
		System.out.println("Rest Point URL is "+url);
		RestTemplate restTemplate = new RestTemplate();
		
	    return restTemplate.getForObject(url, String.class);
	}

}
