package com.wolfattire.responseDto;


public class ReportResponseDto {

	private long total_initial_orders;
	private long total_initial_cancelled_orders;
	private long tatal_placed_orders;
	private long total_successful_orders;
	private long total_returned_orders;
	private long total_orders;
	
	private double total_initial_amt;
	private double total_initial_cancelled_amt;
	private double total_placed_amt;
	private double total_delivered_amt;
	private double total_returned_amt;
	private double total_comp_expense;
	private double total_revenue;
	private double total_profit;
	private double total_loss;
	
	private String fromDate;
	private String toDate;
	public long getTotal_initial_orders() {
		return total_initial_orders;
	}
	public void setTotal_initial_orders(long total_initial_orders) {
		this.total_initial_orders = total_initial_orders;
	}
	public long getTotal_initial_cancelled_orders() {
		return total_initial_cancelled_orders;
	}
	public void setTotal_initial_cancelled_orders(long total_initial_cancelled_orders) {
		this.total_initial_cancelled_orders = total_initial_cancelled_orders;
	}
	public long getTatal_placed_orders() {
		return tatal_placed_orders;
	}
	public void setTatal_placed_orders(long tatal_placed_orders) {
		this.tatal_placed_orders = tatal_placed_orders;
	}
	public long getTotal_successful_orders() {
		return total_successful_orders;
	}
	public void setTotal_successful_orders(long total_successful_orders) {
		this.total_successful_orders = total_successful_orders;
	}
	public long getTotal_returned_orders() {
		return total_returned_orders;
	}
	public void setTotal_returned_orders(long total_returned_orders) {
		this.total_returned_orders = total_returned_orders;
	}
	public long getTotal_orders() {
		return total_orders;
	}
	public void setTotal_orders(long total_orders) {
		this.total_orders = total_orders;
	}
	public double getTotal_initial_amt() {
		return total_initial_amt;
	}
	public void setTotal_initial_amt(double total_initial_amt) {
		this.total_initial_amt = total_initial_amt;
	}
	public double getTotal_initial_cancelled_amt() {
		return total_initial_cancelled_amt;
	}
	public void setTotal_initial_cancelled_amt(double total_initial_cancelled_amt) {
		this.total_initial_cancelled_amt = total_initial_cancelled_amt;
	}
	public double getTotal_placed_amt() {
		return total_placed_amt;
	}
	public void setTotal_placed_amt(double total_placed_amt) {
		this.total_placed_amt = total_placed_amt;
	}
	public double getTotal_delivered_amt() {
		return total_delivered_amt;
	}
	public void setTotal_delivered_amt(double total_delivered_amt) {
		this.total_delivered_amt = total_delivered_amt;
	}
	public double getTotal_returned_amt() {
		return total_returned_amt;
	}
	public void setTotal_returned_amt(double total_returned_amt) {
		this.total_returned_amt = total_returned_amt;
	}
	public double getTotal_comp_expense() {
		return total_comp_expense;
	}
	public void setTotal_comp_expense(double total_comp_expense) {
		this.total_comp_expense = total_comp_expense;
	}
	public double getTotal_revenue() {
		return total_revenue;
	}
	public void setTotal_revenue(double total_revenue) {
		this.total_revenue = total_revenue;
	}
	public double getTotal_profit() {
		return total_profit;
	}
	public void setTotal_profit(double total_profit) {
		this.total_profit = total_profit;
	}
	public double getTotal_loss() {
		return total_loss;
	}
	public void setTotal_loss(double total_loss) {
		this.total_loss = total_loss;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
}
