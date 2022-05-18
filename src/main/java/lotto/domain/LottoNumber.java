package lotto.domain;

import exception.OutOfRangeException;
import lotto.util.Parser;
import lotto.util.Range;

public class LottoNumber {
	public static final int LOTTO_RANGE_MIN = 1;
	public static final int LOTTO_RANGE_MAX = 45;
	private final LottoNumberType type;
	private final int number;

	private LottoNumber(int number, LottoNumberType type) {
		validateNumber(number);
		this.number = number;
		this.type = type;
	}

	public static LottoNumber of(int number) {
		return new LottoNumber(number, LottoNumberType.DEFAULT);
	}

	public static LottoNumber of(String number) {
		return of(number, LottoNumberType.DEFAULT);
	}

	public static LottoNumber of(String number, LottoNumberType type) {
		validateTextNumber(number);
		return new LottoNumber(Parser.toInt(number.trim()), type);
	}

	private static void validateTextNumber(String number) {
		if (number == null || number.isBlank()) {
			throw new IllegalArgumentException("로또번호는 빈 값이거나 null 이면 생성할 수 없습니다.");
		}
	}

	private static void validateNumber(int number) {
		if (Range.of(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX).notContain(number)) {
			throw new OutOfRangeException("생성된 로또번호가 범위를 벗어났습니다. (범위 : " + Range.of(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX) + ")");
		}
	}

	public boolean checkType(LottoNumberType type) {
		return this.type == type;
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
		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
