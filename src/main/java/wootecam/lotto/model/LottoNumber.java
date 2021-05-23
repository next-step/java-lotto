package wootecam.lotto.model;

import java.util.Objects;

import wootecam.lotto.exception.LottoException;
import wootecam.util.StringUtils;

public class LottoNumber implements Comparable<LottoNumber> {
	private static final int MAX_NUMBER = 45;
	private static final int MIN_NUMBER = 1;
	private final int number;

	public LottoNumber(String numberInput) {
		if (!StringUtils.isNumeric(numberInput)) {
			throw new LottoException("정수형이 아닙니다.");
		}
		int number = Integer.parseInt(numberInput);
		this.checkRangeLottoNumber(number);
		this.number = number;
	}

	public LottoNumber(int number) {
		this.checkRangeLottoNumber(number);
		this.number = number;
	}

	private void checkRangeLottoNumber(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new LottoException("로또 번호는 1~45만 가능합니다.");
		}
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return this.number - lottoNumber.getNumber();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	public String valueOf() {
		return String.valueOf(this.number);
	}
}
