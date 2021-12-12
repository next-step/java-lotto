package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	private final int lottoNumber;

	public LottoNumber(int randomNumber) {
		this.lottoNumber = randomNumber;
	}

	public int value() {
		return this.lottoNumber;
	}

	@Override
	public int compareTo(LottoNumber compareLottoNumber) {
		return Integer.compare(this.value(), compareLottoNumber.value());
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
}
