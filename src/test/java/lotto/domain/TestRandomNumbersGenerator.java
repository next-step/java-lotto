package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class TestRandomNumbersGenerator implements RandomNumbersGenerator {

	private int number;

	public TestRandomNumbersGenerator() {
		this.number = MIN;
	}

	@Override
	public List<Integer> generateNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < LottoNumbers.LOTTO_NUMBER_LENGTH; i++) {
			numbers.add(getNextNumber());
		}
		return numbers;
	}

	private int getNextNumber() {
		if (number > MAX) {
			number = MIN;
		}
		return number++;
	}

}
