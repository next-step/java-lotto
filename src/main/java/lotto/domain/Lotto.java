package lotto.domain;

import java.util.Objects;

public final class Lotto {
	private final Integer lotto;
	private static final Integer ONE = 1;
	private static final Integer FORTYFIVE = 45;

	public Lotto(final Integer lotto) {
		this.lotto = validate(lotto);
	}

	private Integer validate(final Integer lotto) {
		if (lotto >= ONE && lotto <= FORTYFIVE) {
			return lotto;
		}
		throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해주세요.");
	}

	public boolean isBetween(final Integer start, final Integer end) {
		return lotto >= start && lotto <= end;
	}

	@Override
	public boolean equals(final Object o) {
		if (this.lotto == o)
			return true;
		if (o == null)
			return false;
		Integer lotto1 = (Integer)o;
		return Objects.equals(lotto, lotto1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto);
	}

	@Override
	public String toString() {
		return Integer.toString(lotto);
	}
}
