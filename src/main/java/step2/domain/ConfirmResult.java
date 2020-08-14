package step2.domain;

import step2.constants.PrizeGrade;

import java.util.Objects;

public class ConfirmResult {

	private final PrizeGrade prizeGrade;

	public ConfirmResult(int matchCount) {
		this.prizeGrade = PrizeGrade.of(matchCount);
	}
	//For Test
	public ConfirmResult(PrizeGrade prizeGrade) {
		this.prizeGrade = prizeGrade;
	}

	public PrizeGrade getPrizeGrade() {
		return prizeGrade;
	}

	public int getReward() {
		return prizeGrade.getReward();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConfirmResult that = (ConfirmResult) o;
		return prizeGrade == that.prizeGrade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(prizeGrade);
	}
}
