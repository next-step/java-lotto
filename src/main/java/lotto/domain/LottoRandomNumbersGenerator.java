package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumbersGenerator implements RandomNumbersGenerator {

	private static final List<Integer> numbers;

	static {
		numbers = new ArrayList<>();
		for (int number = LottoNumber.MIN; number <= LottoNumber.MAX; number++) {
			numbers.add(number);
		}
	}

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
