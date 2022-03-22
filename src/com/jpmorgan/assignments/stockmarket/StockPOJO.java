package com.jpmorgan.assignments.stockmarket;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockPOJO {

	private String stockSymbol;
	private String type;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;

	private Map<LocalDateTime, StockTrade> trades;

	public Map<LocalDateTime, StockTrade> getTrades() {
		return trades;
	}

	public void setTrades(Map<LocalDateTime, StockTrade> trades) {
		this.trades = trades;
	}

	public StockPOJO(String symbol, String type, Double lastDividend, Double fixedDividend, Double parValue) {
		this.setStockSymbol(symbol);
		this.setType(type);
		this.setLastDividend(lastDividend);
		this.setFixedDividend(fixedDividend);
		this.setParValue(parValue);
		this.trades = new HashMap<LocalDateTime, StockTrade>();
	}

	@Override
	public String toString() {
		return "StockPOJO [symbol=" + stockSymbol + ", type=" + type + ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + ", trades=" + trades + "]";
	}

	public Double getPrice() {

		return this.trades.size() > 0 ? getLatestPrice() : 0.0;

	}

	private Double getLatestPrice() {

		LocalDateTime lastAddedStockKey = Collections.max(this.trades.entrySet(), Map.Entry.comparingByKey()).getKey();

		return this.trades.get(lastAddedStockKey).getPrice();
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String symbol) {
		this.stockSymbol = symbol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}

}
