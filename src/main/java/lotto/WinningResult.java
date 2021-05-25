package lotto;

import java.util.Map;

public class WinningResult {

	private final Map<Winner, Integer> dashboard;

	public WinningResult(Lotto win, Lottos lottos) {
		dashboard = LottoUtils.defaultDashboard();

		lottos.values().forEach(lotto -> {
			Winner winner = lotto.winningCheck(win);
			dashboard.computeIfPresent(winner, (k, v) -> ++v);
		});
	}

	public Map<Winner, Integer> dashboard() {
		return dashboard;
	}

	public long totalAward() {
		return dashboard.keySet()
			.stream()
			.mapToLong(winner -> winner.prize * dashboard.get(winner))
			.reduce(0L, Long::sum);
	}
}
