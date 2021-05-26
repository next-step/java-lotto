package lotto;

import exception.LottoException;

import static type.LottoExceptionType.LOTTO_COUNT_OVER_PRICE;

public class LottoCount {

	private final int autoCount;
	private final int userCount;

	public LottoCount(final LottoMoney lottoMoney, final int userCount) {
		int totalLottoCount = lottoMoney.calculateLottoCount();
		checkLottoCount(totalLottoCount, userCount);

		this.userCount = userCount;
		this.autoCount = totalLottoCount - userCount;
	}

	private void checkLottoCount(final int totalLottoCount, final int userCount) {
		if (totalLottoCount < userCount) {
			throw LottoException.of(LOTTO_COUNT_OVER_PRICE);
		}
	}

	public int autoCount(){
		return this.autoCount;
	}

	public int userCount(){
		return this.userCount;
	}
}
