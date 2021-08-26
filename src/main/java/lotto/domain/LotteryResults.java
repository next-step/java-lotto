package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.type.WinningType;

public class LotteryResults {
	private final static int PRICE_OF_LOTTO = 1000;
	private final List<LotteryResult> results;

	public LotteryResults(List<LotteryResult> results) {
		this.results = results;
	}

	public float getTotalYield() {
		int totalWinnings = results.stream()
			.mapToInt(result -> result.getWinningType().getWinnings())
			.sum();
		int purchaseAmount = results.size() * PRICE_OF_LOTTO;

		return totalWinnings / (float)purchaseAmount;
	}

	public Map<WinningType, Integer> getDrawResult() {
		List<WinningType> resultWinningTypes = results.stream()
			.map(LotteryResult::getWinningType)
			.collect(Collectors.toList());

		Map<WinningType, Integer> drawResultMap = new HashMap<>();
		for (WinningType winningType : WinningType.values()) {
			int count = Collections.frequency(resultWinningTypes, winningType);
			drawResultMap.put(winningType, count);
		}

		return drawResultMap;
	}
}
