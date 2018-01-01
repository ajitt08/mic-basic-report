package com.wolfattire.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wolfattire.apiClient.ApiRestClient;
import com.wolfattire.constant.ApplicationConstants;
import com.wolfattire.home.dto.ClientDto;
import com.wolfattire.home.dto.Orders;
import com.wolfattire.responseDto.ReportResponseDto;
import com.wolfattire.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Value("${wolfattire.cost.ads}")
	private int add_cost;
	
	@Value("${wolfattire.cost.salary}")
	private int salary;
	
	@Value("${wolfattire.cost.software}")
	private int software_cost;
	
	@Value("${wolfatire.cost.shipping}")
	private int shipping_cost;
	
	@Autowired
	private ApiRestClient restClient;
	
	@Override
	public ReportResponseDto getReportsFromShopify(String fromDate, String toDate) {
		System.out.println("service started");
		ReportResponseDto reportDto = new ReportResponseDto();
		ClientDto clientResponse = restClient.getDataFromShopify(fromDate, toDate);
		System.out.println("service End:"+clientResponse);
		
		getReportDetails (clientResponse.getOrders(), reportDto);
		reportDto.setFromDate(fromDate);
		reportDto.setToDate(toDate);
		
		return reportDto;
	}

	private void getReportDetails(List<Orders> orders, ReportResponseDto reportDto) {
		long total_orders = 0;
		long tatal_placed_orders = 0;
		long total_successful_orders = 0;
		long total_initial_cancelled_orders = 0;
		long total_returned_orders = 0;
		long total_initial_orders = 0;
		
		double total_revenue = 0;
		double total_profit = 0;
		double total_loss = 0;
		double total_placed_amt = 0;
		double total_delivered_amt = 0;
		double total_returned_amt = 0;
		double total_comp_expense = 0;
		double total_initial_cancelled_amt = 0;
		double total_initial_amt = 0;
		
		List<String> tagList = new ArrayList<String>();
		String [] tags ;
		for (Orders order : orders) {
			total_orders++;
			tags = order.getTags().split(",");
			tagList = Arrays.asList(tags);
			
			if (!tagList.isEmpty()) {
				if (tagList.contains(ApplicationConstants.ORDER_CANCELLED)) {
					total_initial_cancelled_orders++;
					total_initial_cancelled_amt = total_initial_cancelled_amt + order.getTotal_price() + shipping_cost;
				}
				else if (tagList.contains(ApplicationConstants.ORDER_DELIVERED)) {
					total_successful_orders++;
					total_delivered_amt = total_delivered_amt + order.getTotal_price() + shipping_cost;
				}
				else if (tagList.contains(ApplicationConstants.ORDER_RETURNED)) {
					total_returned_orders++;
					total_returned_amt = total_returned_amt + order.getTotal_price() + shipping_cost;
				}
				else if (tagList.contains(ApplicationConstants.ORDER_PLACED)) {
					tatal_placed_orders++;
					total_placed_amt = total_placed_amt + order.getTotal_price() + shipping_cost;
				}
				else {
					total_initial_orders++;
					total_initial_amt = total_initial_amt + order.getTotal_price() + shipping_cost;
				}
			}
			
		}
		total_revenue = total_delivered_amt + total_returned_amt + total_placed_amt;
		total_comp_expense = add_cost + salary + software_cost;
		total_profit = (total_delivered_amt * 20) / 100;
		
		
		//total_loss = 
		reportDto.setTatal_placed_orders(tatal_placed_orders);
		reportDto.setTotal_initial_cancelled_orders(total_initial_cancelled_orders);
		reportDto.setTotal_loss(total_loss);
		reportDto.setTotal_orders(total_orders);
		reportDto.setTotal_profit(total_profit);
		reportDto.setTotal_returned_orders(total_returned_orders);
		reportDto.setTotal_revenue(total_revenue);
		reportDto.setTotal_successful_orders(total_successful_orders);
		reportDto.setTotal_placed_amt(total_placed_amt);
		reportDto.setTotal_delivered_amt(total_delivered_amt);
		reportDto.setTotal_returned_amt(total_returned_amt);
		reportDto.setTotal_comp_expense(total_comp_expense);
		reportDto.setTotal_initial_orders(total_initial_orders);
		reportDto.setTotal_initial_amt(total_initial_amt);
		
	}

	
}
