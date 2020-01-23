package com.sapient.pe.fbleague.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.pe.fbleague.client.RestClient;

@Controller
@RequestMapping("/report")
public class FBLeagueController {
	
	@Value( "${standings.endpoint}" )
	private String standingsApiURL;
	
	@Value( "${country.endpoint}" )
	private String countryApiURL;
	
	@Value( "${league.endpoint}" )
	private String leagueApiURL;
	
	
	@Value( "${api.key}" )
	private String apiKey;
	
	@Autowired
	private RestClient restClient;
	
	@RequestMapping(value="/summary", method=RequestMethod.GET)
	
	public ResponseEntity<String> generateSummaryReport(@RequestParam(value = "league", defaultValue = "148") String league) throws IOException{
		
		String result = restClient.getResponse(standingsApiURL+league+apiKey);
		return ResponseEntity.ok(result);
	}
	
	@RequestMapping(value="/countries", method=RequestMethod.GET)
	
	public ResponseEntity<String> getCountryList() throws IOException{
		
		String result = restClient.getResponse(countryApiURL+apiKey);
		return ResponseEntity.ok(result);
	}
	
	@RequestMapping(value="/leagues", method=RequestMethod.GET)
	
	public ResponseEntity<String> getLeagueList(@RequestParam(value = "country", defaultValue = "41") String country) throws IOException{
		
		String result = restClient.getResponse(leagueApiURL+country+apiKey);
		return ResponseEntity.ok(result);
	}

}
