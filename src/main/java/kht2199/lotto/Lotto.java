package kht2199.lotto;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author heetaek.kim
 */
public final class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = Collections.unmodifiableList(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
