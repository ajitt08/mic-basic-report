package com.wolfattire.home.dto;

import java.util.List;

public class Orders {

	private double total_price;
	private double subtotal_price;
	private double total_tax;
	private String tags;
	private List<LineItems> line_items;
	private String contact_email;
	private int order_number;
	private String email;
	
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public double getSubtotal_price() {
		return subtotal_price;
	}
	public void setSubtotal_price(double subtotal_price) {
		this.subtotal_price = subtotal_price;
	}
	public double getTotal_tax() {
		return total_tax;
	}
	public void setTotal_tax(double total_tax) {
		this.total_tax = total_tax;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public List<LineItems> getLine_items() {
		return line_items;
	}
	public void setLine_items(List<LineItems> line_items) {
		this.line_items = line_items;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
