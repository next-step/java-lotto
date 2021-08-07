package lotto.model;

import java.util.Objects;

public class LottoNumber {

	private final int lottoNumber;

	public LottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public int getLottoNumber() {
		return lottoNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return getLottoNumber() == that.getLottoNumber();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLottoNumber());
	}
}
