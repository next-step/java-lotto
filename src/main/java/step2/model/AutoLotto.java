package step2.model;

import java.util.Arrays;
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

	public Rank getRank(String winNumbers) {
		return getRank(Arrays.stream(winNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
	}

	public Rank getRank(List<Integer> winNumbers) {
		int matchCount = 0;
		for (Integer number : numbers) {
			matchCount += contains(winNumbers, number);
		}
		return Rank.valueOf(matchCount);
	}

	private int contains(List<Integer> winNumbers, Integer number) {
		if (winNumbers.contains(number)) {
			return 1;
		}
		return 0;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
