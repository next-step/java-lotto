package lotto.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	public static final int LOTTO_MIN_NUMBER = 1;
	public static final int LOTTO_MAX_NUMBER = 45;
	public static final int PICK_COUNT = 6;

	private List<Integer> numbers;

	public LottoNumberGenerator() {
		this.numbers = createNumbers();
	}

	private List<Integer> createNumbers() {
		return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}

	public List<Integer> pick() {
		Collections.shuffle(numbers);
		return numbers.stream()
				.limit(PICK_COUNT)
				.collect(Collectors.toList());
	}

	public List<Integer> pick(String number) {
		return validate(parseNumber(number));
	}

	private List<Integer> parseNumber(String number) {
		return Arrays.stream(number.split("[\\s,]+"))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}

	private List<Integer> validate(List<Integer> numbers) {
		if(!isCorrectNumbers(numbers)) {
			throw new IllegalArgumentException(
					String.format("%d ~ %d 사이의 중복되지 않은 숫자 %d개만 가능합니다.",
							LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, PICK_COUNT));
		}
		return numbers;
	}

	private boolean isCorrectNumbers(List<Integer> numbers) {
		int count = (int) numbers.stream()
				.distinct()
				.filter(number -> hasNumberInRange(number))
				.count();
		return count == PICK_COUNT;
	}

	private boolean hasNumberInRange(Integer number) {
		return LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER;
	}

}
