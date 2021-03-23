package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	public List<Integer> numbers() {
		List<Integer> baseNumbers = makeBaseNumbers();
		Collections.shuffle(baseNumbers);
		return pickupSixNumbers(baseNumbers);
	}

	private List<Integer> makeBaseNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	private List<Integer> pickupSixNumbers(List<Integer> baseNumbers) {
		List<Integer> results = baseNumbers.subList(0, 6);
		Collections.sort(results);
		return results;
	}
}
