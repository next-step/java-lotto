package kht2199.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kht2199.lotto.exception.number.LottoNumberLengthException;

public class LottoNumbers {

	private final List<LottoNumber> numbers;

	/**
	 * primitive type으로 초기화하려면 {@link LottoNumber#valuesOf(int...)}로 초기화한다.
	 */
	public LottoNumbers(List<LottoNumber> numbers) throws LottoNumberLengthException {
		if (numbers == null || numbers.size() != 6) {
			throw new LottoNumberLengthException();
		}
		this.numbers = Collections.unmodifiableList(
			new ArrayList<>(numbers)
		);
	}

	public boolean contains(LottoNumber number) {
		return this.numbers.contains(number);
	}

	public int countMatched(LottoNumbers numbers) {
		return (int) this.numbers.stream()
			.filter(numbers::contains)
			.count();
	}

	/**
	 * @return [1, 2, 3, 4, 5, 6]
	 */
	@Override
	public String toString() {
		final StringBuilder buffer = new StringBuilder();
		buffer.append('[');
		for (int i = 0, numbersSize = numbers.size(); i < numbersSize; i++) {
			final boolean isCurrentLastIndex = i + 1 == numbersSize;
			LottoNumber number = numbers.get(i);
			buffer.append(number.value());
			buffer.append(isCurrentLastIndex ? "]" : ", ");
		}
		return buffer.toString();
	}
}
