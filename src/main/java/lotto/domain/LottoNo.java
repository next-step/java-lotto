package lotto.domain;

import java.util.Objects;

public class LottoNo {
	private final int number;

	public LottoNo(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException("유효하지 않은 번호입니다.");
		}
		this.number = number;
	}

	@Override
	public String toString() {
		return "" + number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNo lottoNo = (LottoNo) o;
		return number == lottoNo.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
