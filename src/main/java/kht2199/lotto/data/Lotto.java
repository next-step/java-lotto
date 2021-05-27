package kht2199.lotto.data;

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

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append('[');
		for (int i = 0, numbersSize = numbers.size(); i < numbersSize; i++) {
			boolean lastIndex = i + 1 == numbersSize;
			Integer number = numbers.get(i);
			buffer.append(number);
			buffer.append(lastIndex ? "]" : ", ");
		}
		return buffer.toString();
	}
}
