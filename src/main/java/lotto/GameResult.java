package lotto;

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.stream.Collectors.*;
import static lotto.LottoShop.*;

import java.util.Map;

public class GameResult {

	private static final int INITIAL_VALUE = 0;

	private final int buyCount;
	private final Map<Rank, Integer> dashboard;

	public GameResult(WinningLotto winningLotto, Lottos lottos) {
		buyCount = lottos.count();
		dashboard = defaultDashboard();

		lottos.values()
			.stream()
			.map(winningLotto::resultOf)
			.forEach(rank -> dashboard.computeIfPresent(rank, (k, v) -> ++v));
	}

	private static Map<Rank, Integer> defaultDashboard() {
		return stream(Rank.values())
			.collect(toMap(w -> w, w -> INITIAL_VALUE));
	}

	public Map<Rank, Integer> dashboard() {
		return unmodifiableMap(dashboard);
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
}
