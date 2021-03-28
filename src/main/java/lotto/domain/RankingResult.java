package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankingResult {
	private final Map<Ranking, Integer> result = new HashMap<>();

	public RankingResult() {
		for (Ranking ranking : Ranking.values()) {
			result.put(ranking, 0);
		}
	}

	public Map<Ranking, Integer> getResult() {
		return result;
	}

	public void saveRanking(int matchCount, boolean matchBonusCount) {
		Ranking ranking = Ranking.valueOf(matchCount, matchBonusCount);
		result.put(ranking, result.getOrDefault(ranking, 0) + 1);
	}

	public double getRateOfReturn(int purchasePrice) {
		int totalReturn = 0;
		for (Ranking ranking : result.keySet()) {
			totalReturn += result.get(ranking) * ranking.getPrice();
		}
		return Math.floor(((double)totalReturn / purchasePrice) * 100) / 100.0;
	}

}
