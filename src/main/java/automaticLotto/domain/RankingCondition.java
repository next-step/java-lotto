package automaticLotto.domain;

import java.util.Objects;

public class RankingCondition {
	private static final int BONUS_RELATED_NUMBER = 5;

	private int matchedCount;
	private boolean isBonusNumberContained;

	public RankingCondition(Ranking ranking) {
		this.matchedCount = ranking.getMatchedCount();
		this.isBonusNumberContained = false;

		if (ranking == Ranking.RANKING_2) {
			this.isBonusNumberContained = true;
		}
	}

	public RankingCondition(int matchedCount, boolean isBonusNumberContained) {
		this.matchedCount = matchedCount;
		this.isBonusNumberContained = isBonusNumberContained;

		validateMatchedCount(matchedCount);
	}

	private void validateMatchedCount(int matchedCount) {
		if (matchedCount < Ranking.getMinimumMatchedCount()
			|| matchedCount > Ranking.getMaximumMatchedCount()) {
			throw new RuntimeException("match count must be within ranking range(0 - 6)");
		}
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
