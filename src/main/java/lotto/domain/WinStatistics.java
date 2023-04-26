package lotto.domain;

public class WinStatistics implements Comparable<WinStatistics> {

	private final PrizeType prizeType;
	private int count;

	public WinStatistics(PrizeType prizeType, int count) {
		if (prizeType.winCount.getWinCount() < 3) {
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
	public int compareTo(WinStatistics o) {
		return this.prizeType.winCount.getWinCount() - o.prizeType.winCount.getWinCount();
	}
}
