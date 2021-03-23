package im.juniq.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	public List<Integer> numbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			numbers.add(i);
		}

		Collections.shuffle(numbers);

		List<Integer> results = numbers.subList(0, 6);
		Collections.sort(results);

		return results;
	}
}
