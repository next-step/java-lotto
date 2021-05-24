package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumbersGenerator implements RandomNumbersGenerator {

	private static final List<Integer> numbers = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
			.boxed()
			.collect(Collectors.toList());

	@Override
	public List<Integer> generateNumbers() {
		List<Integer> randomNumbers = this.generateRandomNumbers(Lotto.NUMBER_LENGTH);
		Collections.sort(randomNumbers);
		return randomNumbers;
	}

	private List<Integer> generateRandomNumbers(int length) {
		Collections.shuffle(numbers);
		return new ArrayList<>(numbers.subList(numbers.size() - length, numbers.size()));
	}

}
