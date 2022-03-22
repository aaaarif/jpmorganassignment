package com.jpmorgan.assignments.stockmarket;

public class StockTrade {

	private String type;
	private Integer quantity;
	private Double price;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public StockTrade(String type, Integer quantity, Double price) {
		this.setType(type);
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	@Override
	public String toString() {
		return "StockTrade [type=" + type + ", quantity=" + quantity + ", price=" + price + "]";
	}

}