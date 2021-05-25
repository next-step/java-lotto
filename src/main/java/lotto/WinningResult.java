package lotto;

import java.util.Map;

public class WinningResult {

	private static final long FOURTH_REWARD = 5000L;
	private static final long THIRD_REWARD = 50000L;
	private static final long SECOND_REWARD = 1500000L;
	private static final long FIRST_REWARD = 2000000000L;

	private final Map<Winner, Integer> dashboard;

	public WinningResult(Lotto win, Lottos lottos) {
		dashboard = null;
	}

	public Map<Winner, Integer> dashboard() {
		return dashboard;
	}

	public long totalPrize() {
		return 0;
	}
}
