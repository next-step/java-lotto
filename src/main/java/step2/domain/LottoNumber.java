package step2.domain;

import step2.LottoException;

import java.util.Objects;

import static step2.configuration.LottoConfig.LOTTO_MAX_NUM;
import static step2.configuration.LottoConfig.LOTTO_MIN_NUM;
import static step2.constants.MessageConstant.OVER_NUMBER_RANGE;
import static step2.constants.MessageConstant.INPUT_SHOULD_INTEGER;

public class LottoNumber {

	private int number;

	public LottoNumber(int number) {
		this.number = createValidLottoNumber(number);
	}

	public LottoNumber(String number) {
		this.number = createValidLottoNumber(number);
	}

	private int createValidLottoNumber(String number) {
		try {
			return createValidLottoNumber(Integer.parseInt(number));
		} catch (NumberFormatException e) {
			throw new LottoException(INPUT_SHOULD_INTEGER, e);
		}
	}

	private int createValidLottoNumber(int number) {
		if(!isValidRange(number)) {
			throw new LottoException(OVER_NUMBER_RANGE);
		}
		return number;
	}

	private boolean isValidRange(int number) {
		return number >= LOTTO_MIN_NUM && number <= LOTTO_MAX_NUM;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumber that = (LottoNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
