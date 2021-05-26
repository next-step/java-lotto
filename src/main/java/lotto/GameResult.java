package lotto;

import static lotto.Money.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

	private final int buyCount;
	private final Map<Rank, Integer> dashboard;

	public GameResult(WinningNumber winningNumber, Lottos lottos) {
		buyCount = lottos.count();
		dashboard = defaultDashboard();

		lottos.values().forEach(lotto -> {
			Rank rank = winningNumber.resultOf(lotto);
			dashboard.computeIfPresent(rank, (k, v) -> ++v);
		});
	}

	public Map<Rank, Integer> dashboard() {
		return Collections.unmodifiableMap(dashboard);
	}

	public double earningRate() {
		return ((double) totalAward()) / (buyCount * LOTTO_PRICE);
	}

	private long totalAward() {
		return dashboard.keySet()
			.stream()
			.mapToLong(w -> w.award() * dashboard.get(w))
			.reduce(0L, Long::sum);
	}

	private static Map<Rank, Integer> defaultDashboard() {
		Map<Rank, Integer> dashboard = new HashMap<>();

		Arrays.stream(Rank.values()).forEach(winner -> {
			dashboard.put(winner, 0);
		});

		return dashboard;
	}
}
