package com.jpmorgan.assignments.stockmarket;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StockHelper {

	public static Double calculateDividend(Double price, StockPOJO stock) {

		return stock.getType().equals("COMMON") ? stock.getLastDividend() / price
				: stock.getFixedDividend() * stock.getParValue() / price;
	}

	public static Double calculatePERatio(Double price, StockPOJO stock) {
		return price / stock.getLastDividend();
	}

	public static Double calculateVolumeWeightedStockPrice(StockPOJO stock) {

		final LocalDateTime last15MinTime = LocalDateTime.now().minusMinutes(15);

		final Set<LocalDateTime> last15MinTradedKeys = stock.getTrades().keySet().stream()
				.filter(record -> record.isAfter(last15MinTime)).collect(Collectors.toSet());

		final Integer totalQuantity = last15MinTradedKeys.stream()
				.mapToInt(record -> stock.getTrades().get(record).getQuantity()).sum();

		final Double totalStockPrice = last15MinTradedKeys.stream().mapToDouble(
				record -> stock.getTrades().get(record).getPrice() * stock.getTrades().get(record).getQuantity()).sum();

		return totalStockPrice / totalQuantity;
	}

	public static void addStock(Integer quantity, Double price, StockPOJO stock) {

		final StockTrade trade = new StockTrade("BUY", quantity, price);

		stock.getTrades().put(LocalDateTime.now(), trade);
	}

	public static void sellStock(Integer quantity, Double price, StockPOJO stock) {
		final StockTrade trade = new StockTrade("SELL", quantity, price);
		stock.getTrades().put(LocalDateTime.now(), trade);
	}

	public static Double calculateGeometricMean(Map<String, StockPOJO> stocks) {

		Double totalStockPrice = 0.0;
		Integer totalQuantity = 0;

		for (StockPOJO stock : stocks.values()) {

			totalQuantity += stock.getTrades().entrySet().stream().mapToInt(record -> record.getValue().getQuantity())
					.sum();

			totalStockPrice += stock.getTrades().entrySet().stream()
					.mapToDouble(record -> record.getValue().getPrice() * record.getValue().getQuantity()).sum();
		}

		return Math.pow(totalStockPrice, 1.0 / totalQuantity);
	}

}
