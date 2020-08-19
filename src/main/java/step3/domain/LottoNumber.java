package step3.domain;

import step3.LottoException;

import java.util.Objects;

import static step3.configuration.LottoConfig.LOTTO_MAX_NUM;
import static step3.configuration.LottoConfig.LOTTO_MIN_NUM;
import static step3.constants.MessageConstant.INPUT_SHOULD_INTEGER;
import static step3.constants.MessageConstant.OVER_NUMBER_RANGE;

public class LottoNumber implements Comparable<LottoNumber> {

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
		if (!isValidRange(number)) {
			throw new LottoException(OVER_NUMBER_RANGE);
		}
		return number;
	}

	private boolean isValidRange(int number) {
		return number >= LOTTO_MIN_NUM && number <= LOTTO_MAX_NUM;
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.number, o.number);
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
