package lotto.domain;

import java.util.Objects;

public class LottoMatchResult {
	private int matchResult;
	private boolean hasBonusNumber;

	public LottoMatchResult(int matchResult, boolean hasBonusNumber) {
		this.matchResult = matchResult;
		this.hasBonusNumber = hasBonusNumber;
	}

	public int getMatchResult() {
		return matchResult;
	}

	public boolean isHasBonusNumber() {
		return hasBonusNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoMatchResult that = (LottoMatchResult) o;
		return matchResult == that.matchResult &&
				hasBonusNumber == that.hasBonusNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matchResult, hasBonusNumber);
	}
}
