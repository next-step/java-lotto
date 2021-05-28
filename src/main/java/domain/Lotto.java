package domain;

import ui.Rank;

import java.util.Arrays;
import java.util.List;

public class Lotto {
	public static final Integer LOTTO_NUMBER_LENGTH = 6;
	private Rank rank = Rank.NONE;

	private final List<Integer> numbers;

	public Lotto (List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	public List<Integer> numbers () {
		return numbers;
	}

	public Rank rank (Rank rank) {
		return this.rank = rank;
	}

	public Rank rank () {
		return rank;
	}
}
