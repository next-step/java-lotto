package lotto.domain;

public class WinningInfo {
	private final Rank rank;
	private final Integer winners;

	public WinningInfo(Rank rank, Integer winners) {
		this.rank = rank;
		this.winners = winners;
	}

	public Rank getRank() {
		return rank;
	}

	public Integer getNumOfWinners() {
		return winners;
	}

	public long calcTotalAmount() {
		return rank.calcTotalAmount(winners);
	}
}
