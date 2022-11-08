package step3.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RateCheckerTest {
	@Test
	void getEarningRate() {
		HashMap<Integer, Integer> testMap = new HashMap<>();
		testMap.put(1, 1);
		testMap.put(4, 1);
		testMap.put(5, 1);
		Money money = new Money(2100000000);
		double earningRate = RateChecker.getEarningRate(testMap, money);
		assertEquals(Math.floor(earningRate * 100) / 100.0, 0.95);
	}
}
