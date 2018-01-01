package com.wolfattire.apiClient;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolfattire.exception.ApplicationException;
import com.wolfattire.home.dto.ClientDto;

@Service
public class ApiRestClient {

	private RestTemplate restTemplate;
	
	@Value("${shopify.orders.custom.data.url}")
	private String url;
	@Value("${shopify.service.user}")
	private String user;
	@Value("${shopify.service.password}")
	private String password;
	@Value("${shopify.servicefields}")
	private String fields;
	
	HttpHeaders header;
	
	public ApiRestClient() {
		restTemplate = new RestTemplate();
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Post construct");
		String plainCreds = String.format("%s:%s", user,password);
		byte[] plainCredsInBytes = plainCreds.getBytes();
		byte[] base64InBytes = Base64.encodeBase64(plainCredsInBytes);
		String base64Cred = new String (base64InBytes);
		
		header = new HttpHeaders();
		header.add("Authorization", "Basic " +base64Cred);
	}
	
	public ClientDto getDataFromShopify (String fromDate, String toDate) {
		ClientDto clientDto = null;
		String shopify_url = url + "?created_at_min=" + fromDate + "&created_at_max=" + toDate + "&fields=" + fields;
		System.out.println("Rest call started");
		try{
			HttpEntity<String> httpEntity = new HttpEntity<>("", header);
			
			ResponseEntity<ClientDto> responseEntity = 
							restTemplate.exchange(shopify_url, HttpMethod.GET, httpEntity, ClientDto.class);
			clientDto = responseEntity.getBody();
		}
		catch (Exception ex){
			throw new ApplicationException("Network Issue with API");
		}
		
		System.out.println("Rest call end");
		return clientDto;
	}
}
