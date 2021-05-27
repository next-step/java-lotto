package kht2199.lotto.data;

import java.util.Collections;
import java.util.List;

import kht2199.lotto.exception.lotto.LottoNumberEmptyException;
import kht2199.lotto.exception.lotto.LottoNumberException;
import kht2199.lotto.exception.lotto.LottoNumberLengthException;

/**
 *
 * @author heetaek.kim
 */
public final class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) throws LottoNumberException {
		validate(numbers);
		this.numbers = Collections.unmodifiableList(numbers);
	}

	private void validate(List<Integer> numbers) throws LottoNumberException {
		if (numbers == null || numbers.isEmpty()) {
			throw new LottoNumberEmptyException();
		}
		if (numbers.size() != 6) {
			throw new LottoNumberLengthException();
		}
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

	public boolean contains(int number) {
		return this.numbers.contains(number);
	}
}
