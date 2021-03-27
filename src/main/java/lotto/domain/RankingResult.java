package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankingResult {
	private final Map<Ranking, Integer> result = new HashMap<>();

	public Map<Ranking, Integer> getResult() {
		return result;
	}

	public void saveRanking(Map<Integer, Integer> winnerCountPerGrade) {
		for (Ranking ranking : Ranking.values()) {
			result.put(ranking, winnerCountPerGrade.getOrDefault(ranking.getMatchCount(), 0));
		}
	}

	public double getRateOfReturn(int purchasePrice) {
		int totalReturn = 0;
		for (Ranking ranking : result.keySet()) {
			totalReturn += result.get(ranking) * ranking.getPrice();
		}
		return Math.floor(((double)totalReturn / purchasePrice) * 100) / 100.0;
	}
}
