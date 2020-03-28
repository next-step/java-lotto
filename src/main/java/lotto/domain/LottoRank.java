package lotto.domain;

public enum LottoRank {
	FOURTH(3,5000),
	THIRD(4,50000),
	SECOND(5,1500000),
	FIRST(6,2000000000);

	private final int correctNumbers;
	private final int earningPrize;

	LottoRank(int correctNumbers, int earningPrize) {
		this.correctNumbers = correctNumbers;
		this.earningPrize = earningPrize;
	}

	public int getCorrectNumbers() {
		return correctNumbers;
	}

	public int getEarningPrize() {
		return earningPrize;
	}
}
