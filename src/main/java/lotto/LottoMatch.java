package lotto;

public enum LottoMatch {
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6)
	;

	LottoMatch(int matchCount) {
		this.matchCount = matchCount;
	}

	private final int matchCount;

	public int matchCount() {
		return this.matchCount;
	}
}
