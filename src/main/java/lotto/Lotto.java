package lotto;

import java.util.List;

public class Lotto {

	private static final int REQUIRED_COUNT = 6;

	private final List<LottoNumber> numbers;

	public Lotto(List<LottoNumber> numbers) {
		validateNumbers(numbers);

		this.numbers = numbers;
	}

	public Winner winningCheck(Lotto winLotto) {
		return Winner.valueOf(numbers.stream()
				.filter(winLotto.numbers::contains)
				.count());
	}

	private void validateNumbers(List<LottoNumber> numbers) {
		long distinctCount = numbers.stream()
				.distinct()
				.count();

		if (numbers.size() != REQUIRED_COUNT || distinctCount != REQUIRED_COUNT) {
			throw new IllegalArgumentException("Numbers must consist of 6 distinct numbers.");
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
