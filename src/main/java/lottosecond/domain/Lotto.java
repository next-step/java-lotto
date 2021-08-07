package lottosecond.domain;

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
		for (LottoNumber lastWeekNumber : lastWeekNumbers.numbers) {
			matchedCount += contains(lastWeekNumber) ? 1 : 0;
		}
		return matchedCount;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return numbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		return numbers().toString();
	}

}
