package lotto.model;

import lotto.message.ErrorMessage;
import lotto.utils.LottoCountCalculator;

public class LottoCount {

	private final int manualCount;
	private final int autoCount;

	public LottoCount(int manualCount, Money money) {
		int totalCount = LottoCountCalculator.calculateLottoCount(money.getPurchaseMoney());
		checkPositiveCount(manualCount);
		checkOverMoney(totalCount, manualCount);
		this.manualCount = manualCount;
		autoCount = totalCount - manualCount;
	}

	public int getManualLottoCount() {
		return manualCount;
	}

	public int getAutoLottoCount() {
		return autoCount;
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
