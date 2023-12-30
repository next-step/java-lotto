package lotto.domain;

import java.util.Objects;

public final class LottoNumber {
	private static final Integer ONE = 1;
	private static final Integer FORTYFIVE = 45;
	private final Integer lottoNumber;

	public LottoNumber(final Integer lottoNumber) {
		validate(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void validate(final Integer lotto) {
		if (lotto >= ONE && lotto <= FORTYFIVE) {
			return;
		}

		throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해주세요.");
	}

	public boolean isBetween(final Integer start, final Integer end) {
		return lottoNumber >= start && lottoNumber <= end;
	}

	@Override
	public boolean equals(final Object o) {
		if (this.lottoNumber == o)
			return true;
		if (o == null)
			return false;
		Integer lotto1 = (Integer)o;

		return Objects.equals(lottoNumber, lotto1);
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
