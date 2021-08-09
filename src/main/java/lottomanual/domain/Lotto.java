package lottomanual.domain;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lotto {

	public static final int NUMBERS_SIZE_LIMIT = 6;

	private final Set<LottoNumber> numbers;

	private Lotto(Set<LottoNumber> numbers) {
		validateSize(numbers.size());
		this.numbers = numbers;
	}

	public static Lotto of(Set<LottoNumber> numbers) {
		return new Lotto(numbers);
	}

	public static Lotto of(List<LottoNumber> numbers) {
		return of(new TreeSet<>(numbers));
	}

	public static Lotto of(String numbersText) {
		return Arrays.stream(numbersText.split(","))
		             .map(LottoNumber::valueOf)
		             .collect(collectingAndThen(toList(), Lotto::of));
	}

	private static void validateSize(int size) {
		if (size != NUMBERS_SIZE_LIMIT) {
			throw new LottoNumbersSizeException();
		}
	}

	public Set<LottoNumber> numbers() {
		return Collections.unmodifiableSet(numbers);
	}

	public int matchingQuantityFrom(Lotto lastWeekNumbers) {
		int matchedCount = 0;
		for (LottoNumber lastWeekNumber : lastWeekNumbers.numbers) {
			matchedCount += contains(lastWeekNumber) ? 1 : 0;
		}
		return matchedCount;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return numbers.contains(lottoNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lotto lotto = (Lotto) o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

	@Override
	public String toString() {
		return numbers().toString();
	}

}
