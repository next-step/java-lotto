package lotto.domain;

public class LottoPurchaseHistory {

	private int autoLottoCount;
	private int manualLottoCount;

	public LottoPurchaseHistory(int autoLottoCount, int manualLottoCount) {
		this.autoLottoCount = autoLottoCount;
		this.manualLottoCount = manualLottoCount;
	}

	public int getAutoLottoCount() {
		return this.autoLottoCount;
	}

	public int getManualLottoCount() {
		return this.manualLottoCount;
	}
}
