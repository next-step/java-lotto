package lotto.domain;

public class LottoCount {
	private final int manualCount;
	private final int autoCount;

	public LottoCount(Money money, int manualCount) {
		this.manualCount = manualCount;
		this.autoCount = money.buyMax(LottoLottery.LOTTO_PRICE_PER_PIECE) - manualCount;
	}

	public int getManualCount() {
		return manualCount;
	}

	public int getAutoCount() {
		return autoCount;
	}
}
