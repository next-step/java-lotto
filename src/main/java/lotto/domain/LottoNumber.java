package lotto.domain;

import java.util.Objects;

public final class LottoNumber {
	private static final Integer MIN_LOTTO_NUMBER = 1;
	private static final Integer MAX_LOTTO_NUMBER = 45;
	private final Integer lottoNumber;

	public LottoNumber(final Integer lottoNumber) {
		validate(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void validate(final Integer lotto) {
		if (lotto >= MIN_LOTTO_NUMBER && lotto <= MAX_LOTTO_NUMBER) {
			return;
		}

		throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해주세요.");
	}

	@Override
	public boolean equals(final Object o) {
		if (this.lottoNumber == o)
			return true;
		if (o == null)
			return false;
		LottoNumber lotto1 = (LottoNumber)o;

		return Objects.equals(lottoNumber, lotto1.lottoNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}

	@Override
	public String toString() {
		return Integer.toString(lottoNumber);
	}
}
