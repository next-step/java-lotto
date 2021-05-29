package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_MINIMUM_NUMBER = 1;
	public static final int LOTTO_MAXIMUM_NUMBER = 45;
	public static final int LOTTO_LENGTH = 6;

	private final Set<LottoNumber> numbers;

	public Lotto(List<Integer> numberList) {
		numbers = Collections.unmodifiableSortedSet(
			new TreeSet<>(numberList.stream()
				.map(x -> LottoNumber.of(x))
				.collect(Collectors.toList())));

		validateNumberListSize(numbers);
	}

	private void validateNumberListSize(Set<LottoNumber> candidateLotto) {
		if (candidateLotto.size() != LOTTO_LENGTH) {
			throw new RuntimeException("lotto numbers must be consist of six numbers");
		}
	}

	public boolean hasNumber(LottoNumber number) {
		return numbers.contains(number);
	}

	public Set<LottoNumber> getNumbers() {
		return numbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(numbers, lotto1.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
