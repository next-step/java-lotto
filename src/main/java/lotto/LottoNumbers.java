package lotto;

import java.util.List;

public class LottoNumbers {
	private final List<Integer> numbers;

	public LottoNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public int matchedCount(LottoNumbers other) {
		return (int)this.numbers
			.stream()
			.filter(other::contains)
			.count();
	}

	public String toString() {
		return numbers.toString();
	}

	private boolean contains(int number) {
		return numbers.contains(number);
	}
}
