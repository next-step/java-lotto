package step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
	private static final int MIN_LOTTO_VALUE = 1;
	private static final int MAX_LOTTO_VALUE = 45;
	private static final List<LottoNumber> LOTTO_VALUES = IntStream.rangeClosed(MIN_LOTTO_VALUE, MAX_LOTTO_VALUE)
			.boxed()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	private static final String LOTTO_NUMBER_PHRASES = "로또 당첨 번호는 1 이상 45 이하의 숫자여야 합니다.";

	private final int number;

	public LottoNumber(int number) {
		validLottoNumber(number);
		this.number = number;
	}

	private void validLottoNumber(int number) {
		if (number < MIN_LOTTO_VALUE || number > MAX_LOTTO_VALUE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_PHRASES);
		}
	}

	public static List<LottoNumber> getRandomNumbers(int numberCount) {
		Collections.shuffle(LOTTO_VALUES);
		return Collections.unmodifiableList(
				LOTTO_VALUES.stream()
						.limit(numberCount)
						.sorted()
						.collect(Collectors.toList())
		);
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof LottoNumber) {
			LottoNumber anotherNumber = (LottoNumber) obj;
			return this.number == anotherNumber.number;
		}
		return false;
	}

	@Override
	public int compareTo(LottoNumber number) {
		return Integer.compare(this.number, number.number);
	}
}
