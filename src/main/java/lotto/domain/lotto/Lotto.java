package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

	private static int LOTTO_BALL_NUMBERS_LIMIT = 6;

	private Set<Integer> numbers;

	private Lotto(List<Integer> inputNumbers) {
		validateNumbersCount(inputNumbers);
		this.numbers = new HashSet<>(inputNumbers);
		validateDuplicateNumbers(numbers);
	}

	private void validateNumbersCount(List<Integer> inputNumbers) {
		if (inputNumbers.size() != LOTTO_BALL_NUMBERS_LIMIT) {
			throw new IllegalArgumentException(String.format("로또는 %s개의 숫자만 가지고 있습니다",
					LOTTO_BALL_NUMBERS_LIMIT));
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

	// TODO: 2019-11-01 GETTER를 없앨 수 있는 방법이 있는지 생각해보기
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
