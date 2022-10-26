package step2.model.lotto;

import static java.util.stream.IntStream.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;
	private static final List<Integer> AVAILABLE_NUMBERS = range(MIN_NUMBER, MAX_NUMBER + 1).boxed().collect(Collectors.toList());

	private final List<Integer> numbers;

	public Lotto() {
		shuffle();
		numbers = pick();
		Collections.sort(numbers);
	}

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public int getMatchCount(List<Integer> values) {
		return (int)values.stream()
			.filter(numbers::contains).count();
	}

	private void shuffle() {
		Collections.shuffle(AVAILABLE_NUMBERS);
	}

	private List<Integer> pick() {
		return range(0, LOTTO_SIZE)
			.mapToObj(AVAILABLE_NUMBERS::get)
			.collect(Collectors.toList());
	}
}
