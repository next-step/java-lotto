package lotto.domain;

public final class MatchingNumbers {
	private final static int RANK2 = 2;
	private final Integer matchingNumbers;
	private final Boolean bonusNumber;

	public MatchingNumbers(final Integer matchingNumbers, final Boolean bonusNumber) {
		this.matchingNumbers = matchingNumbers;
		this.bonusNumber = bonusNumber;
	}

	public Boolean isMatching(final int matchCount) {
		return matchingNumbers.equals(matchCount);
	}

	public Boolean isBonus(int rank) {
		if (rank == RANK2) {
			return bonusNumber;
		}

		return false;
	}
}
