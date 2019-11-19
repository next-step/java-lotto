package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int NUMBER_COUNT = 6;
	private List<Integer> numbers;

	public AutoLotto() {
		List<Integer> lottoNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());
		Collections.shuffle(lottoNumbers);
		numbers = lottoNumbers.subList(0, NUMBER_COUNT);
		Collections.sort(numbers);
	}

	public AutoLotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public int getMatchNumberCount(List<Integer> compareNumbers) {
		compareNumbers.retainAll(this.numbers);
		return compareNumbers.size();
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
