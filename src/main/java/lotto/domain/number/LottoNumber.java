package lotto.domain.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

	private final int lottoNumber;

	LottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
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

	public int getLottoNumber() {
		return lottoNumber;
	}

	@Override
	public int compareTo(LottoNumber compareLottoNumber) {
		return this.lottoNumber - compareLottoNumber.lottoNumber;
	}
}
