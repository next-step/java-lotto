package lotto.domain.input;

import lotto.LottoTVShow;

public class LottoBuyCount {

	private int totalBuyCount;

	private int autoLottoCount;

	private int manualLottoCount;


	public LottoBuyCount(Money purchaseAmount, int manualLottoCount) {
		int autoMoney = purchaseAmount.getMoney() - (manualLottoCount * LottoTVShow.LOTTO_PRICE_PER_SHEET.getMoney());
		this.autoLottoCount = isPositiveNumber(autoMoney / LottoTVShow.LOTTO_PRICE_PER_SHEET.getMoney());
		this.manualLottoCount = isPositiveNumber(manualLottoCount);
		this.totalBuyCount = autoLottoCount + manualLottoCount;
	}

	private int isPositiveNumber(int lottoBuyCount) {
		if (lottoBuyCount < 0) {
			throw new IllegalArgumentException();
		}
		return lottoBuyCount;
	}

	public int getTotalBuyCount() {
		return totalBuyCount;
	}

	public int getAutoLottoCount() {
		return autoLottoCount;
	}

	public int getManualLottoCount() {
		return manualLottoCount;
	}
}
