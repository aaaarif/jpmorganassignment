package com.jpmorgan.assignments.stockmarket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StockData {

	private static String COMMON = "COMMON";

	private static String PREFERRED = "PREFERRED";

	private Map<String, StockPOJO> data;

	public StockPOJO getRandomStock() {

		final Map<String, StockPOJO> data = getData();

		final Random generator = new Random();
		final Object[] values = data.values().toArray();
		return (StockPOJO) values[generator.nextInt(values.length)];

	}

	public StockData() {
		this.data = new HashMap<>();
		data.put("TEA", new StockPOJO("TEA", COMMON, 0.0, 0.0, 100.0));
		data.put("POP", new StockPOJO("POP", COMMON, 8.0, 0.0, 100.0));
		data.put("ALE", new StockPOJO("ALE", COMMON, 23.0, 0.0, 60.0));
		data.put("GIN", new StockPOJO("GIN", PREFERRED, 8.0, 0.2, 100.0));
		data.put("JOE", new StockPOJO("JOE", COMMON, 13.0, 0.0, 250.0));
	}

	public Map<String, StockPOJO> getData() {
		return data;
	}
}
