package lotto.model;

import lotto.message.ErrorMessage;
import lotto.utils.LottoCountCalculator;

public class LottoPayment {

	private final int manualCount;
	private final Money money;

	public LottoPayment(int manualCount, Money money) {
		checkPositiveCount(manualCount);
		checkOverMoney(LottoCountCalculator.calculateLottoCount(money.getPurchaseMoney()), manualCount);
		this.manualCount = manualCount;
		this.money = money;
	}

	public int getManualLottoCount() {
		return manualCount;
	}

	public int getAutoLottoCount() {
		return LottoCountCalculator.calculateLottoCount(money.getPurchaseMoney()) - manualCount;
	}

	private void checkPositiveCount(int manualCount) {
		if (manualCount < 0) {
			throw new IllegalArgumentException(ErrorMessage.COUNT_POSITIVE_MESSAGE);
		}
	}

	private void checkOverMoney(int totalCount, int manualCount) {
		if (manualCount > totalCount) {
			throw new IllegalArgumentException(ErrorMessage.COUNT_OVER_MESSAGE);
		}
	}
}
