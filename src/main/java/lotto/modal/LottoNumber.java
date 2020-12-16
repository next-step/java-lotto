package lotto.modal;

import java.util.Objects;

public class LottoNumber {

	public static final int LOTTO_NUMBER_BOUND_MAX = 45;
	public static final int LOTTO_NUMBER_BOUND_MIN = 1;

	private final Integer number;

	public LottoNumber(int lottoNumber) {

		validationLottoNumber(lottoNumber);
		this.number = lottoNumber;
	}

	private void validationLottoNumber(int lottoNumber) {

		if (lottoNumber < LOTTO_NUMBER_BOUND_MIN || lottoNumber > LOTTO_NUMBER_BOUND_MAX) {
			throw new IllegalArgumentException("Lotto 번호 범위 에러: 1 ~ 45 사이의 값을 입력해 주세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number.equals(that.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return number.toString();
	}
}
