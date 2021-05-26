package lotto;

import static lotto.Money.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {

	private final int buyCount;
	private final Map<Winner, Integer> dashboard;

	public WinningResult(Lotto win, Lottos lottos) {
		buyCount = lottos.count();
		dashboard = defaultDashboard();

		lottos.values().forEach(lotto -> {
			Winner winner = lotto.winningCheck(win);
			dashboard.computeIfPresent(winner, (k, v) -> ++v);
		});
	}

	public Map<Winner, Integer> dashboard() {
		return dashboard;
	}

	public double earningRate() {
		return totalAward() * 1.0
			/ (buyCount * LOTTO_PRICE);
	}

	private long totalAward() {
		return dashboard.keySet()
			.stream()
			.mapToLong(winner -> winner.award() * dashboard.get(winner))
			.reduce(0L, Long::sum);
	}

	private static Map<Winner, Integer> defaultDashboard() {
		Map<Winner, Integer> dashboard = new HashMap<>();

		Arrays.stream(Winner.values()).forEach(winner -> {
			dashboard.put(winner, 0);
		});

		return dashboard;
	}
}
