package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final Map<Prize, Integer> matchedMap;
	private final double rate;

	public LottoResult(WinningNumbers winningNumbers, List<Lotto> lottos, LottoPrice lottoPrice) {
		this.matchedMap = new HashMap<>();

		lottos.forEach(lotto -> {
					Prize prize = Prize.from(winningNumbers.getMatchedCount(lotto), winningNumbers.hasBonusNumber(lotto));
					matchedMap.put(prize, matchedMap.getOrDefault(prize, 0) + 1);
				});

		this.rate = calculateRate(lottoPrice);
	}

	private double calculateRate(LottoPrice lottoPrice) {
		int prize = matchedMap.keySet().stream()
				.mapToInt(key -> key.getPrice() * matchedMap.get(key))
				.sum();

		return (double) prize / lottoPrice.getPrice();
	}

	public double getRate() {
		return rate;
	}

	public int getNumberOfMatchedLotto(Prize prize) {
		return matchedMap.getOrDefault(prize, 0);
	}

	public boolean isLoss() {
		return rate < 1;
	}
}
