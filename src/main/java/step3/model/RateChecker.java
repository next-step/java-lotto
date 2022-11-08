package step3.model;

import java.util.Map;

public class RateChecker {
	public static double getEarningRate(Map<Integer, Integer> hitCntMap, Money money) {
		int prizeMoneySum = hitCntMap.keySet().stream()
				.mapToInt(rank -> rank)
				.map(rank -> Awards.getPrize(rank, hitCntMap.get(rank)))
				.sum();
		return (double) prizeMoneySum / money.getMoney();
	}
}
