package lotto;

import java.util.List;

public class LottoNumbers {
	private final List<Integer> numbers;
	private final int bonusNumber;

	public LottoNumbers(List<Integer> numbers, int bonusNumber) {
		this.numbers = numbers;
		this.bonusNumber = bonusNumber;
	}

	public LottoNumbers(List<Integer> numbers) {
		this.numbers = numbers;
		this.bonusNumber = -1;
	}

	private boolean contains(int number) {
		return numbers.contains(number);
	}

	public int matchedCount(LottoNumbers other) {
		return (int)this.numbers
			.stream()
			.filter(other::contains)
			.count();
	}

	public boolean isMatchBonus(LottoNumbers other) {
		return this.bonusNumber == other.bonusNumber;
	}

	@Override
	public String toString() {
		return this.numbers.toString();
	}
}
