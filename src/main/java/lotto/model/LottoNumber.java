package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoNumber {
	static final int MIN_NUMBER = 1;
	static final int MAX_NUMBER = 45;

	private static final String EXCEPTION_MESSAGE_OF_RANGE_VALIDATION = "로또 번호 숫자 범위에 벗어납니다.";

	private static final Map<Integer, LottoNumber> numbersCache = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
		.boxed()
		.collect(toMap(num -> num, LottoNumber::new));

	private final int number;

	private LottoNumber(int inputNumber) {
		validateRange(inputNumber);
		this.number = inputNumber;
	}

	private void validateRange(int inputNumber) {
		if (inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER ) {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE_OF_RANGE_VALIDATION);
		}
	}

	int getNumber() {
		return number;
	}

	public static LottoNumber of(int number) {
		LottoNumber lottoNumber = numbersCache.get(number);
		return Optional.ofNullable(lottoNumber)
			.orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE_OF_RANGE_VALIDATION));
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		LottoNumber that = (LottoNumber)other;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
