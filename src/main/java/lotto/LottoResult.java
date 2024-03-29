package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final Map<Long, Integer> matchedMap;
	private final double rate;

	public LottoResult(WinningNumbers winningNumbers, List<Lotto> lottos, int purchasePrice) {
		this.matchedMap = new HashMap<>();

		lottos.stream()
				.map(winningNumbers::getMatchedCount)
				.filter(count -> count >= Prize.getMinimumCount())
				.forEach(count -> matchedMap.put(count, matchedMap.getOrDefault(count, 0) + 1));

		this.rate = calculateRate(purchasePrice);
	}

	private double calculateRate(int purchasePrice) {
		int prize = matchedMap.keySet().stream()
				.mapToInt(key -> Prize.findPriceByCount(key) * matchedMap.get(key))
				.sum();

		return (double) prize / purchasePrice;
	}

	public double getRate() {
		return rate;
	}

	public int getNumberOfMatchedLotto(Long matchedCount) {
		return matchedMap.getOrDefault(matchedCount, 0);
	}

	public boolean isLoss() {
		return rate < 1;
	}
}
