package lotto.domain;

public class PrizeSituation implements Comparable<PrizeSituation> {

	private final PrizeType prizeType;
	private final int prizeCount;

	public PrizeSituation(PrizeType prizeType, int count) {
		if (prizeType.score.getScore() < 3) {
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
}
