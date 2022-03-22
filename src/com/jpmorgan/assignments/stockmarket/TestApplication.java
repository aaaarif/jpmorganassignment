package com.jpmorgan.assignments.stockmarket;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestApplication {

	@Test
	public void testApplication() {

		final StockData data1 = new StockData();

		final StockPOJO st = data1.getRandomStock();

		final Double dividend = StockHelper.calculateDividend(19.9, st);

		assertNotEquals(dividend, 0);

		final Double peRation = StockHelper.calculatePERatio(3.9, st);

		assertNotEquals(peRation, 0);
		
		// add/sell some stocks
		new StockData().getData().values().forEach(details -> {

			StockHelper.addStock(5, 5.0, details);
			StockHelper.sellStock(3, 3.0, details);

			// calculate VolumeWeightedStockPrice
			final Double volumeWeightedStockPrice = StockHelper.calculateVolumeWeightedStockPrice(details);

			assertNotEquals(volumeWeightedStockPrice, 0);
		});

		final Double gm = StockHelper.calculateGeometricMean(new StockData().getData());

		assertNotEquals(gm, 0);
	}

}