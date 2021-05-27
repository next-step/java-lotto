package lotto.domain;

import static lotto.util.ValidationUtils.*;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

	private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
	private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
	private static final String INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 %d에서 %d 사이입니다.";
	private static final String NUMBERS_ONLY_MESSAGE = "로또 번호는 숫자만 입력해주세요.";

	private static final Map<Integer, LottoNumber> lottoNumberMap = IntStream.rangeClosed(LOTTO_NUMBER_LOWER_BOUND,
		LOTTO_NUMBER_UPPER_BOUND)
		.boxed()
		.collect(Collectors.toMap(Function.identity(), LottoNumber::new));

	public static LottoNumber of(String numberString) {
		validateNumberPattern(numberString);

		return of(Integer.parseInt(numberString));
	}

	private static void validateNumberPattern(String numberString) {
		if (!validateNumber(numberString)) {
			throw new IllegalArgumentException(NUMBERS_ONLY_MESSAGE);
		}
	}

	public static LottoNumber of(int number) {
		validate(number);

		return lottoNumberMap.get(number);
	}

	private static void validate(int number) {
		if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
			throw new IllegalArgumentException(
				String.format(INVALID_LOTTO_NUMBER_MESSAGE, LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND));
		}
	}

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
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

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return this.number - lottoNumber.number;
	}

}
