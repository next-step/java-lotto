package lotto.domain;

public class Lotto {
	private final Numbers numbers;

	public Lotto(Numbers numbers) {
		this.numbers = numbers;
	}

	public Numbers getNumbers() {
		return numbers;
	}
}
