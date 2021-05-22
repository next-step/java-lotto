package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumbersGenerator implements RandomNumbersGenerator {

	@Override
	public List<Integer> generateNumbers() {
		List<Integer> numbers = this.generateRandomNumbers(LottoNumbers.LENGTH);
		sortAsc(numbers);
		return numbers;
	}

	private List<Integer> generateRandomNumbers(int length) {
		List<Integer> numbers = new ArrayList<>();
		for (int number = MIN; number <= MAX; number++) {
			numbers.add(number);
		}
		Collections.shuffle(numbers);
		return new ArrayList<>(numbers.subList(numbers.size() - length, numbers.size()));
	}

	private void sortAsc(List<Integer> numbers) {
		Collections.sort(numbers);
	}

}
