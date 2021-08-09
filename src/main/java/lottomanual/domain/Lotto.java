package lottomanual.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

	public static final int NUMBERS_SIZE_LIMIT = 6;

	private final Set<LottoNumber> numbers;

	public Lotto(String numbersText) {
		this(toSet(toList(numbersText)));
	}

	public Lotto(List<Integer> numbers) {
		this(toSet(numbers));
	}

	private static List<Integer> toList(String text) {
		String[] numberTexts = text.split(",");
		validateSize(numberTexts.length);
		return Arrays.stream(numberTexts).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
	}

	private static Set<LottoNumber> toSet(List<Integer> numbers) {
		Set<LottoNumber> lottoNumbers = new TreeSet<>();
		for (Integer number : numbers) {
			lottoNumbers.add(LottoNumber.valueOf(number));
		}
		return lottoNumbers;
	}

	public Lotto(Set<LottoNumber> numbers) {
		validateSize(numbers.size());
		this.numbers = numbers;
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
