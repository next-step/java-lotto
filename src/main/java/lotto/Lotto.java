package lotto;

public class Lotto {
	private final Numbers numbers;

	private Lotto(Numbers numbers) {
		this.numbers = numbers;
	}

	public static Lotto createRandom() {
		return new Lotto(Numbers.createRandom());
	}
}
