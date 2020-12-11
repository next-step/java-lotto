package com.woowahan.lotto.model;

import com.woowahan.lotto.constant.Message;

public class LottoNo {
	public static final int LOTTO_START_NUMBER = 1;
	public static final int LOTTO_END_NUMBER = 45;

	private final int number;

	private LottoNo(int number) {
		validateParameter(number);
		this.number = number;
	}

	public static LottoNo of(int number) {
		return new LottoNo(number);
	}

	private void validateParameter(int number) {
		if (!validateNumber(number)) {
			throw new IllegalArgumentException(Message.MSG_ERROR_LOTTO_NUMBER);
		}
	}

	private boolean validateNumber(int number) {
		return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		LottoNo lottoNo = (LottoNo)object;

		return number == lottoNo.number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public String toString() {
		return Integer.toString(this.number);
	}
}
