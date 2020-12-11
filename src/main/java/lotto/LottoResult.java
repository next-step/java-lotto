package lotto;

public class LottoResult {
	private final Rank rank;

	public LottoResult(int matchesCount) {
		this.rank = Rank.ofMatchesCount(matchesCount);
	}

	public boolean isMatchesRank(Rank rank) {
		return this.rank.equals(rank);
	}
}
