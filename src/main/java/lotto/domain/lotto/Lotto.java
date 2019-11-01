package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

	private static final int LOTTO_BALL_NUMBERS_LIMIT = 6;
	@SuppressWarnings("FieldCanBeLocal")
	private static final String LOTTO_NUMBERS_COUNT_ERROR_MSG = "로또는 %s개의 숫자만 가질 수 있습니다";
	@SuppressWarnings("FieldCanBeLocal")
	private static final String ANSWER_NUMBERS_COUNT_ERROR_MSG = "로또는 %s개의 숫자로만 비교될 수 있습니다";

	private final Set<Integer> numbers;
	private LottoPrize status;

	private Lotto(List<Integer> inputNumbers) {
		validateNumbersCount(inputNumbers, LOTTO_NUMBERS_COUNT_ERROR_MSG);
		this.numbers = new HashSet<>(inputNumbers);
		validateDuplicateNumbers(numbers);
		this.status = LottoPrize.UNKNOWN;
	}

	private void validateNumbersCount(List<Integer> inputNumbers, String errorMessage) {
		if (inputNumbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException(String.format(errorMessage, LOTTO_BALL_NUMBERS_LIMIT));
		}
	}

	private void validateDuplicateNumbers(Set<Integer> numbers) {
		if (numbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다");
		}
	}

	public static Lotto of(List<Integer> inputNumbers) {
		return new Lotto(inputNumbers);
	}

	public void examine(List<Integer> answerNumbers) {
		validateNumbersCount(answerNumbers, ANSWER_NUMBERS_COUNT_ERROR_MSG);
		this.status = LottoPrize.of(countMatchedNumbers(answerNumbers));
	}

	private long countMatchedNumbers(List<Integer> answerNumbers) {
		return answerNumbers.stream()
				.filter(e -> numbers.contains(e))
				.count();
	}

	public LottoPrize getStatus() {
		return status;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lotto lotto = (Lotto) o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

}
