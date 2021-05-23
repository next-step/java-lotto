package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final int TWO_LOTTO_NUMBERS_LENGTH = Constants.LOTTO_NUMBERS_LENGTH * 2;
	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> numbers() {
		return this.numbers;
	}

	public int checkWinning(List<Integer> winningNumber) {
		Set<Integer> set = new HashSet<>(winningNumber);
		set.addAll(this.numbers);
		return TWO_LOTTO_NUMBERS_LENGTH - set.size();
	}
}
