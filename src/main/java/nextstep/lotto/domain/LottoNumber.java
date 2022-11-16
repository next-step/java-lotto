package nextstep.lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {

	private static final LottoNumber[] NUMBERS;
	private static final int MIN = 1;
	private static final int MAX = 45;

	static {
		NUMBERS = new LottoNumber[45];
		for (int i = 0; i < 45; i++) {
			NUMBERS[i] = new LottoNumber(i+1);
		}
	}
	private final int number;

	public static LottoNumber lottoNumber(final int number) {
		if(number < MIN || number > MAX) {
			throw new IllegalArgumentException("로또 번호는 1-45만 가능합니다.");
		}
		return NUMBERS[number-1];
	}

	public static LottoNumber lottoNumber(final String number) {
		return lottoNumber(Integer.parseInt(number));
	}
	private LottoNumber(int number) {
		this.number = number;
	}

	public static List<LottoNumber> lottoNumbers() {
		return Arrays.asList(NUMBERS.clone());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {return true;}
		if (o == null || getClass() != o.getClass()) {return false;}

		LottoNumber that = (LottoNumber) o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public String toString() {
		return number + "";
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.number, o.number);
	}
}
