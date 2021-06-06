package com.nextstep.lotto.lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	private static final String LOTTO_NUMBERS_CAN_FROM_1_TO_45 = "로또 번호는 1부터 45까지의 숫자여야 합니다.";
	private final int number;

	public LottoNumber(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(LOTTO_NUMBERS_CAN_FROM_1_TO_45);
		}
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return number - lottoNumber.number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
