package lotto.domain;

import java.util.Objects;

public class RankSituation {

	private final Rank rank;
	private final int count;

	public RankSituation(Rank rank, int count) {
		this.rank = rank;
		this.count = count;
	}

	public Rank getRank() {
		return this.rank;
	}

	public int getCount() {
		return this.count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RankSituation that = (RankSituation)o;
		return count == that.count && rank == that.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, count);
	}

	public long calculateProfit() {
		long winningMoney = this.rank.getWinningMoney();
		return winningMoney * this.count;
	}
}
