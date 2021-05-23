package lotto.domain;

import java.util.Objects;

public class LottoResult {
	private final Rank rank;

	public LottoResult(Rank rank) {
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoResult that = (LottoResult) o;
		return rank == that.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank);
	}
}
