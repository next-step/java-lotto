package lotto;

import exception.LottoException;

import static type.LottoExceptionType.LOTTO_COUNT_OVER_PRICE;
import static type.LottoExceptionType.WRONG_LOTTO_COUNT;

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
		if(userCount < 0){
			throw LottoException.of(WRONG_LOTTO_COUNT);
		}

		if (totalLottoCount < userCount) {
			throw LottoException.of(LOTTO_COUNT_OVER_PRICE);
		}
	}

	public int autoCount() {
		return this.autoCount;
	}

	public int userCount() {
		return this.userCount;
	}

	public boolean isEmptyUserCount() {
		return this.userCount == 0;
	}
}
