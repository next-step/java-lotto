package lotto.domain;

public final class MatchingNumbers {
	private final static int RANK2 = 2;
	private final Integer matchingNumbers;
	private final Integer bonusNumber;

	public MatchingNumbers(final Integer matchingNumbers, final Integer bonusNumber) {
		this.matchingNumbers = matchingNumbers;
		this.bonusNumber = bonusNumber;
	}

	public Boolean isMatching(final int matchCount) {
		return matchingNumbers.equals(matchCount);
	}

	public Integer isBonus(final int rank) {
		if (rank == RANK2) {
			return bonusNumber;
		}

		return 0;
	}
}
