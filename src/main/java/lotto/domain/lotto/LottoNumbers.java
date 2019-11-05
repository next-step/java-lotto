package lotto.domain.lotto;

import java.util.*;

public class LottoNumbers {

	private static final int LOTTO_BALL_NUMBERS_LIMIT = 6;
	private static final int LOTTO_BALL_MAX_NUMBER = 45;
	private static final int LOTTO_BALL_MIN_NUMBER = 1;
	private static final String LOTTO_NUMBERS_COUNT_ERROR_MSG = "로또는 %s개의 숫자만 가질 수 있습니다";

	private final Set<Integer> numbers;

	LottoNumbers(List<Integer> inputNumbers) {
		validateNumbersCount(inputNumbers);
		validateNumbersRange(inputNumbers);
		this.numbers = new HashSet<>(inputNumbers);
		validateDuplicateNumbers(numbers);
	}

	private void validateNumbersCount(List<Integer> inputNumbers) {
		if (inputNumbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException(String.format(LOTTO_NUMBERS_COUNT_ERROR_MSG, LOTTO_BALL_NUMBERS_LIMIT));
		}
	}

	private void validateNumbersRange(List<Integer> inputNumbers) {
		for (int number : inputNumbers) {
			validateNumberRange(number);
		}
	}

	private void validateNumberRange(int number) {
		if (number > LOTTO_BALL_MAX_NUMBER || number < LOTTO_BALL_MIN_NUMBER) {
			throw new IllegalArgumentException(String.format("로또 번호는 %s ~ %s 사이여야 합니다 (입력 : %s)",
					LOTTO_BALL_MIN_NUMBER, LOTTO_BALL_MAX_NUMBER, number));
		}
	}

	private void validateDuplicateNumbers(Set<Integer> numbers) {
		if (numbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다");
		}
	}

	long countMatchedNumbers(List<Integer> answerNumbers) {
		return answerNumbers.stream()
				.filter(numbers::contains)
				.count();
	}

	boolean isBonusNumberMatched(int bonusNumber) {
		return numbers.contains(bonusNumber);
	}

	Set<Integer> get() {
		return Collections.unmodifiableSet(numbers);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumbers that = (LottoNumbers) o;
		return Objects.equals(numbers, that.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

}
