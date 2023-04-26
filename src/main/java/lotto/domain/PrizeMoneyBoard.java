package lotto.domain;

public class PrizeMoneyBoard implements Comparable<PrizeMoneyBoard> {

	private final PrizeType prizeType;
	private final int count;

	public PrizeMoneyBoard(PrizeType prizeType, int count) {
		if (prizeType.score.getScore() < 3) {
			throw new IllegalArgumentException("상금 로또가 아닙니다.");
		}
		this.prizeType = prizeType;
		this.count = count;
	}

	public PrizeType getPrizeType() {
		return prizeType;
	}

	public int getCount() {
		return count;
	}

	@Override
	public int compareTo(PrizeMoneyBoard o) {
		return this.prizeType.score.getScore() - o.prizeType.score.getScore();
	}
}
