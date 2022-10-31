package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	public static final int PRICE = 1000;
	public static final int LOTTO_NUMBER_QUANTITY = 6;
	public static final List<Integer> CANDIDATES = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

	private final List<Integer> numbers;

	public Lotto() {
		this.numbers = generate();
	}

	private List<Integer> generate() {
		Collections.shuffle(CANDIDATES);

		return CANDIDATES.subList(0, LOTTO_NUMBER_QUANTITY);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
