package step2.model.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;

	private List<Integer> numbers;

	public Lotto() {
		List<Integer> list = new ArrayList<>();
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		numbers = new ArrayList<>(LOTTO_SIZE);
		for (int i = 0; i < LOTTO_SIZE; i++) {
			numbers.add(list.get(i));
		}
		Collections.sort(numbers);
	}

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public int getMatchCount(List<Integer> values) {
		int count = 0;
		for (Integer value : values) {
			if (numbers.contains(value))
				count++;
		}
		return count;
	}
}
