package lotto.dto;

public enum LottoRank {
	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 1_500_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private final int correctNumbers;
	private final int earningMoney;

	LottoRank(int correctNumbers, int earningMoney) {
		this.correctNumbers = correctNumbers;
		this.earningMoney = earningMoney;
	}

	public int getCorrectNumbers() {
		return correctNumbers;
	}

	public int getWinningMoney() {
		return earningMoney;
	}

	public static LottoRank getFromCorrectNumbers(int correctNumbers, boolean matchBonus) {
		if (correctNumbers == FIRST.getCorrectNumbers()) {
			return FIRST;
		}
		if (correctNumbers == SECOND.getCorrectNumbers() && matchBonus) {
			return SECOND;
		}
		if (correctNumbers < FIFTH.getCorrectNumbers()) {
			return null;
		}
		return values()[correctNumbers - 3];
	}
}
