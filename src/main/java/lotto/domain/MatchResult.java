package lotto.domain;

public class MatchResult {
	private final int count;
	private final boolean matchBonus;

	public MatchResult(int count, boolean matchBonus) {
		this.count = count;
		this.matchBonus = matchBonus;
	}

	public int getCount() {
		return count;
	}

	public boolean isMatchBonus() {
		return matchBonus;
	}
}
