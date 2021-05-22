package com.nextstep.lotto.model;

public class LottoNumber {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private int number;

	public LottoNumber(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
		}
		this.number = number;
	}
}
