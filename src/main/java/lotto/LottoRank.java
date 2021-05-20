package lotto;

public enum LottoRank {
	FIRST(6),
	SECOND(5),
	THIRD(4),
	FORTH(3);

	final private int matches;

	LottoRank(final int matches) {
		this.matches = matches;
	}

	public int matches() {
		return this.matches;
	}

}
