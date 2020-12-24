package lotto.modal;

import lotto.util.StringValid;

public class Count {

	private final int count;

	public Count(String count, Money money) {
		this.count = setCheckCount(count);
	}

	private int setCheckCount(String count) {
		if (StringValid.isEmptyStr(count)) {
			throw new IllegalArgumentException("수동 반복 횟수가 입력되지 않았습니다.");
		}

		if (StringValid.isNoNNumber(count)) {
			throw new IllegalArgumentException("수동 반복 횟수을 잘못 입력하였습니다. 숫자만 입력해 주세요.");
		}
		int result = Integer.parseInt(count);

		if (result * LOTTO_PRICE_MONEY > this.userMoney) {
			throw new IllegalArgumentException("금액이 부족합니다.");
		}
		return result;
	}
}
