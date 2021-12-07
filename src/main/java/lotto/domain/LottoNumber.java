package lotto.domain;

import java.util.Random;

public class LottoNumber {
	private final int lottoNumber;

	public LottoNumber(int randomNumber) {
		this.lottoNumber = randomNumber;
	}

	public int getValue() {
		return this.lottoNumber;
	}
}
