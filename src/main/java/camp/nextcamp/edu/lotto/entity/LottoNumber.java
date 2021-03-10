package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;
import static camp.nextcamp.edu.lotto.module.LottoValidator.*;

import java.util.Objects;

import camp.nextcamp.edu.lotto.exception.UserException;

public class LottoNumber implements Comparable<LottoNumber> {
	private final int number;

	public LottoNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	public void validateNumber(int number) {
		if (!isInRange(number)) {
			throw new UserException(IS_NOT_LOTTO_RANGE);
		}
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

	@Override
	public int compareTo(LottoNumber otherNumber) {
		return this.number - otherNumber.number;
	}

	@Override
	public String toString() {
		return String.valueOf(this.number);
	}
}
