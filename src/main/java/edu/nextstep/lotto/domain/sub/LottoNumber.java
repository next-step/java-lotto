package edu.nextstep.lotto.domain.sub;

import java.util.Objects;

public class LottoNumber {
	public static final int START_LIMIT = 1;
	public static final int END_LIMIT = 45;

	private final int lottoNumber;

	public LottoNumber(int number) {
		if (number < START_LIMIT || number > END_LIMIT) {
			throw new IllegalArgumentException("로또 번호는 " + START_LIMIT + "부터 " + END_LIMIT + " 사이만 가능합니다.");
		}
		this.lottoNumber = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LottoNumber)) {
			return false;
		}
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}