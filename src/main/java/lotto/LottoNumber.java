package lotto;

import java.util.Objects;

/**
 * @author : byungkyu
 * @date : 2020/12/13
 * @description :
 **/
public class LottoNumber {
	private static final int MINIMUM_OF_LOTTO_NUMBER = 1;
	private static final int MAXIMUM_OF_LOTTO_NUMBER = 46;
	private final int number;

	public LottoNumber(int number) {
		validate(number);
		this.number = number;
	}

	private void validate(int number) {
		if (number < MINIMUM_OF_LOTTO_NUMBER || number > MAXIMUM_OF_LOTTO_NUMBER) {
			throw new IllegalArgumentException("로또 숫자의 범위는 1부터 46까지 입니다.");
		}
	}

	public int getNumber() {
		return number;
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
}
