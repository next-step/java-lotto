package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int NUMBER_COUNT = 6;

	private List<Integer> numbers;
	private boolean isManual;

	public Lotto(List<Integer> numbers) {
		this(numbers, false);
	}

	public Lotto(List<Integer> numbers, boolean isManual) {
		if(!isValid(numbers)) {
			throw new IllegalArgumentException(
					String.format("%d ~ %d 사이의 중복되지 않은 숫자 %d개만 가능합니다.",
							MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
		}
		this.numbers = numbers;
		this.isManual = isManual;
	}

	private boolean isValid(List<Integer> numbers) {
		int count = (int) numbers.stream()
				.distinct()
				.filter(number -> isInRange(number))
				.count();
		return count == NUMBER_COUNT;
	}

	private boolean isInRange(Integer number) {
		return MIN_NUMBER <= number && number <= MAX_NUMBER;
	}

	public int match(Lotto lotto) {
		int match = 0;
		for(Integer number : numbers) {
			if(lotto.hasNumber(number)) {
				++match;
			}
		}
		return match;
	}

	public boolean hasNumber(Integer number) {
		return numbers.contains(number);
	}

	public boolean isManual() {
		return isManual;
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers.toArray());
	}
}
