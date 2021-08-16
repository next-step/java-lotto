package lotto.domain;

import lotto.exception.MoneyValidationException;

public class LottoCount {

	private static final int LOTTO_PRICE = 1000;

	private final int lottoCount;
	private final int manualLottoCount;

	public LottoCount(int money, int manualLottoCount) {
		validate(money, manualLottoCount);

		this.lottoCount = money / LOTTO_PRICE;
		this.manualLottoCount = manualLottoCount;
	}

	private void validate(int money, int manualLottoCount) {
		if (money < LOTTO_PRICE) {
			throw new MoneyValidationException("로또 구매가 가능한 최소 금액은 " + LOTTO_PRICE + "원 이상입니다.");
		}

		int lottoCount = money / LOTTO_PRICE;

		if (lottoCount < manualLottoCount) {
			throw new MoneyValidationException("수동 로또 개수가 총 개수 보다 많을 수 없습니다.");
		}
	}

	public int getLottoCount() {
		return lottoCount;
	}

	public int getManualLottoCount() {
		return manualLottoCount;
	}

	public int getAutoLottoCount() {
		return lottoCount - manualLottoCount;
	}
}
