package com.wolfattire.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolfattire.responseDto.ReportResponseDto;
import com.wolfattire.service.HomeService;

@RestController
@RequestMapping("/report")
public class HomeController {

	@Autowired
	private HomeService service;
	
	@GetMapping("getReports/{fromDate}/{toDate}")
	public  ReportResponseDto getReports (@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate ) {
		System.out.println("Landed on get method");
		ReportResponseDto response = service.getReportsFromShopify(fromDate, toDate);
		return response;
		
	}
}
