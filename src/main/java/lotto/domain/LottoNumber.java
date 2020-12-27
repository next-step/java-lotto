package lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {

	private static final int TOTAL_LOTTO_NUMBER_MAX = 45;

	private static final int TOTAL_LOTTO_NUMBER_MIN = 1;

	private int lottoNumber;

	public int getLottoNumber() {
		return lottoNumber;
	}

	public LottoNumber() {
		this.lottoNumber = new Random().nextInt(TOTAL_LOTTO_NUMBER_MAX + 1);
	}

	public LottoNumber(int lottoNumber) {
		checkIsInBounds(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void checkIsInBounds(int lottoNumber) {
		if (lottoNumber < TOTAL_LOTTO_NUMBER_MIN || lottoNumber > TOTAL_LOTTO_NUMBER_MAX) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumber that = (LottoNumber) o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}
