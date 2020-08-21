package step2_3.domain;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;
	private static final int PRICE = 1000;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public static int getPrice() {
		return PRICE;
	}
}
