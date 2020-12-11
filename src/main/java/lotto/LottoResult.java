package lotto;

public class LottoResult {
	private final Rank rank;

	public LottoResult(int matchesCount) {
		this.rank = Rank.ofMatchesCount(matchesCount);
	}

	public Rank getRank() {
		return rank;
	}
}
