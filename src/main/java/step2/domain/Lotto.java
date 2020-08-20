package step2.domain;

import java.util.List;

public class Lotto {
	private List<Integer> numbers;
	private int matchingCount;
	private LottoWinning winning;

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
