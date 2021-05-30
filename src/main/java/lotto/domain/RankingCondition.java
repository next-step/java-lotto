package lotto.domain;

import java.util.Objects;

public class RankingCondition {
	private static final int BONUS_RELATED_NUMBER = 5;
	private static final int MINIMUM_MATCH_COUNT = 0;
	private static final int MAXIMUM_MATCH_COUNT = 6;

	private int matchedCount;
	private boolean isBonusNumberContained;

	public RankingCondition(int matchedCount) {
		this(matchedCount, false);
	}

	public RankingCondition(int matchedCount, boolean isBonusNumberContained) {
		this.matchedCount = matchedCount;
		this.isBonusNumberContained = isBonusNumberContained;

		validateMatchedCount(matchedCount);
	}

	private void validateMatchedCount(int matchedCount) {
		if (matchedCount < MINIMUM_MATCH_COUNT
			|| matchedCount > MAXIMUM_MATCH_COUNT) {
			throw new RuntimeException("match count must be within ranking range(0 - 6)");
		}
	}

	public int getMatchedCount() {
		return matchedCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RankingCondition that = (RankingCondition)o;

		if (matchedCount == BONUS_RELATED_NUMBER) {
			return matchedCount == that.matchedCount &&
				isBonusNumberContained == that.isBonusNumberContained;
		}

		return matchedCount == that.matchedCount;
	}

	@Override
	public int hashCode() {
		if (matchedCount == BONUS_RELATED_NUMBER) {
			return Objects.hash(matchedCount, isBonusNumberContained);
		}

		return Objects.hash(matchedCount);
	}
}
