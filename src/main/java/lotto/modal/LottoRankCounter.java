package lotto.modal;

import java.util.Objects;

public class LottoRankCounter {

	private final LottoRank rank;
	private int count;

	public LottoRankCounter(LottoRank rank) {
		this.rank = rank;
	}

	public void increaseCount() {
		this.count++;
	}

	public int getCount() {
		return this.count;
	}

	public int getPrize() {
		return this.rank.getWinnerPrize();
	}

	public String getRankMessage() {
		return this.rank.getRankMessage();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoRankCounter that = (LottoRankCounter)o;
		return count == that.count && rank == that.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, count);
	}

	@Override
	public String toString() {
		return "LottoRankCounter{" +
			"rank=" + rank +
			", count=" + count +
			'}';
	}
}
