package kht2199.lotto.entity;

import java.util.Collections;
import java.util.List;

import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.rank.OutOfRangeOfMatchedCountException;

public class Lotto {

	private final List<LottoNumber> numbers;

	private final boolean auto;

	/**
	 * primitive type으로 초기화하려면 {@link LottoNumber#valuesOf(int...)}로 초기화한다.
	 */
	public Lotto(List<LottoNumber> numbers, boolean auto) throws LottoNumberLengthException {
		if (numbers == null || numbers.size() != 6) {
			throw new LottoNumberLengthException();
		}
		this.numbers = Collections.unmodifiableList(numbers);
		this.auto = auto;
	}

	public boolean contains(LottoNumber number) {
		return this.numbers.contains(number);
	}

	public int countMatched(Lotto numbers) {
		return (int) this.numbers.stream()
			.filter(numbers::contains)
			.count();
	}

	public Rank calculateRank(Lotto winningNumber, LottoNumber bonusNumber) {
		int matched = winningNumber.countMatched(this);
		if (matched == 5L && this.contains(bonusNumber)) {
			return Rank.SECOND;
		}
		try {
			return Rank.valueOf(matched, false);
		} catch (OutOfRangeOfMatchedCountException e) {
			// 발생할 여지가 없어야하기 때문에, RuntimeException 으로 적용.
			throw new RuntimeException(e);
		}
	}

	public boolean isAuto() {
		return auto;
	}

	/**
	 * @return e.g. [1, 2, 3, 4, 5, 6]
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
