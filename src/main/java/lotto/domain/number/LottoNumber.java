package lotto.domain.number;

import java.util.Objects;

import lotto.exception.LottoNumberValidationException;

public class LottoNumber implements Comparable<LottoNumber>{

	private final int lottoNumber;

	LottoNumber(int lottoNumber) {
		if (lottoNumber > 45 ||
			lottoNumber <= 0) {
			throw new LottoNumberValidationException("로또 번호가 잘못 되었습니다.");
		}
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
