package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	public static final int PRICE = 1000;
	public static final int LOTTO_NUMBER_QUANTITY = 6;
	public final List<Integer> candidates = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

	private final List<Integer> numbers;

	public Lotto() {
		this.numbers = generate();
	}

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	private List<Integer> generate() {
		Collections.shuffle(candidates);

		return candidates.subList(0, LOTTO_NUMBER_QUANTITY);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getMatchingCount(List<Integer> winningNumbers) {
		return (int)IntStream.range(0, winningNumbers.size())
			.filter(i -> numbers.contains(winningNumbers.get(i)))
			.count();
	}

	@Override
	public String toString() {
		List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
		return sortedNumbers.toString();
	}
}
