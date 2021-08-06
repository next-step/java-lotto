package lottosecond.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	public static final int NUMBERS_SIZE_LIMIT = 6;

	private final Set<LottoNumber> numbers;

	public Lotto(List<Integer> numbers) {
		this(toSet(numbers));
	}

	private static Set<LottoNumber> toSet(List<Integer> numbers) {
		Set<LottoNumber> lottoNumbers = new TreeSet<>();
		for (Integer number : numbers) {
			lottoNumbers.add(LottoNumber.valueOf(number));
		}
		return lottoNumbers;
	}

	public Lotto(Set<LottoNumber> numbers) {
		if (validateSize(numbers.size())) {
			throw new LottoNumbersSizeException();
		}
		this.numbers = numbers;
	}

	private boolean validateSize(int size) {
		return size != NUMBERS_SIZE_LIMIT;
	}

	public Set<LottoNumber> numbers() {
		return Collections.unmodifiableSet(numbers);
	}

	public int matchingQuantityFrom(Lotto lastWeekNumbers) {
		int matchedCount = 0;
		for (LottoNumber lastWeekNumber : lastWeekNumbers.numbers()) {
			matchedCount += numbers.contains(lastWeekNumber) ? 1 : 0;
		}
		return matchedCount;
	}

	public boolean hasBonus(int bonusNumber) {
		return numbers.contains(LottoNumber.valueOf(bonusNumber));
	}

	@Override
	public String toString() {
		return numbers().toString();
	}

}
