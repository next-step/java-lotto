package lotto.domain;

import java.util.Objects;

public class PrizeSituation implements Comparable<PrizeSituation> {

	public static final int PRIZE_SCORE_MINIMUM = 3;

	private final PrizeType prizeType;
	private final int prizeCount;

	public PrizeSituation(PrizeType prizeType, int count) {
		if (prizeType.score.getScore() < PrizeSituation.PRIZE_SCORE_MINIMUM) {
			throw new IllegalArgumentException("상금 로또가 아닙니다.");
		}
		this.prizeType = prizeType;
		this.prizeCount = count;
	}

	public PrizeType getPrizeType() {
		return prizeType;
	}

	public int getPrizeCount() {
		return prizeCount;
	}

	@Override
	public int compareTo(PrizeSituation o) {
		return this.prizeType.score.getScore() - o.prizeType.score.getScore();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PrizeSituation that = (PrizeSituation)o;
		return prizeCount == that.prizeCount && prizeType == that.prizeType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(prizeType, prizeCount);
	}
}
