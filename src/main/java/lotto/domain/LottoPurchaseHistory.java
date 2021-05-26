package lotto.domain;

public class LottoPurchaseHistory {

	private LottoCount autoLottoCount;
	private LottoCount manualLottoCount;

	public LottoPurchaseHistory(LottoCount autoLottoCount, LottoCount manualLottoCount) {
		this.autoLottoCount = autoLottoCount;
		this.manualLottoCount = manualLottoCount;
	}

	public int getAutoLottoCount() {
		return this.autoLottoCount.getCount();
	}

	public int getManualLottoCount() {
		return this.manualLottoCount.getCount();
	}
}
