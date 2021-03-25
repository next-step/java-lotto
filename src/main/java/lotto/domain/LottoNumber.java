package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		if (isInvalidLottoNumber(lottoNumber)) {
			throw new IllegalArgumentException("1~45 사이의 숫자여야 합니다.");
		}
		this.lottoNumber = lottoNumber;
	}

	private boolean isInvalidLottoNumber(int lottoNumber) {
		if (lottoNumber < 1 || lottoNumber > 45) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}

	@Override
	public int compareTo(LottoNumber l) {
		if (this.lottoNumber > l.lottoNumber) {
			return 1;
		} else if (this.lottoNumber < l.lottoNumber) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return String.valueOf(lottoNumber);
	}
}
