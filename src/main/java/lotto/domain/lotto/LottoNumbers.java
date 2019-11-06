package lotto.domain.lotto;

import java.util.*;

public class LottoNumbers {

	private static final int LOTTO_BALL_NUMBERS_LIMIT = 6;
	private static final String LOTTO_NUMBERS_COUNT_ERROR_MSG = "로또는 %s개의 숫자만 가질 수 있습니다";

	private final Set<LottoNumber> numbers;

	LottoNumbers(List<Integer> inputNumbers) {
		validateNumbersCount(inputNumbers);
		this.numbers = new HashSet<>();
		for (int inputNumber : inputNumbers) {
			numbers.add(LottoNumber.of(inputNumber));
		}
		validateDuplicateNumbers(numbers);
	}

	private void validateNumbersCount(List<Integer> inputNumbers) {
		if (inputNumbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException(String.format(LOTTO_NUMBERS_COUNT_ERROR_MSG, LOTTO_BALL_NUMBERS_LIMIT));
		}
	}

	private void validateDuplicateNumbers(Set<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다");
		}
	}

	long countMatchedNumbers(List<Integer> answerNumbers) {
		validateNumbersCount(answerNumbers);
		return answerNumbers.stream()
				.map(LottoNumber::of)
				.filter(numbers::contains)
				.count();
	}

	boolean isBonusNumberMatched(int bonusNumber) {
		return numbers.contains(LottoNumber.of(bonusNumber));
	}

	Set<LottoNumber> get() {
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
