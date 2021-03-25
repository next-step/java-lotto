package lotto.domain;

import java.util.Map;

public class RateOfReturn {

	public double calculate(Map<Ranking, Integer> result, int purchasePrice) {
		int totalReturn = 0;
		for (Ranking ranking : result.keySet()) {
			totalReturn += result.get(ranking) * ranking.getPrice();
		}
		return Math.floor(((double)totalReturn / purchasePrice) * 100) / 100.0;
	}
}
