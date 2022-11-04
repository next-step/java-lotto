package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidLottoNumberQuantityException;

public class Lotto implements LottoGenerate {
	public static final int PRICE = 1000;
	public static final int LOTTO_NUMBER_QUANTITY = 6;

	private final List<Integer> numbers;

	public Lotto() {
		this.numbers = generate();
	}

	public Lotto(List<Integer> numbers) {
		if (!isValidNumbersSize(numbers)) {
			throw new InvalidLottoNumberQuantityException(ErrorMessage.LOTTO_NUMBERS_QUANTITY_MUST_BE_SIX);
		}
		if (!isValidDistinctNumbers(numbers)) {
			throw new DuplicateLottoNumberException(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_BE_DUPLICATED);
		}
		this.numbers = numbers;
	}

	private boolean isValidNumbersSize(List<Integer> numbers) {
		return numbers.size() == LOTTO_NUMBER_QUANTITY;
	}

	private boolean isValidDistinctNumbers(List<Integer> numbers) {
		return numbers.size() == numbers.stream().distinct().count();
	}

	public List<Integer> generate() {
		final List<Integer> candidates = IntStream.rangeClosed(1, 45)
			.boxed()
			.collect(Collectors.toList());

		Collections.shuffle(candidates);

		return candidates.subList(0, LOTTO_NUMBER_QUANTITY);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getMatchingCount(List<Integer> winningNumbers) {
		return (int)IntStream.range(0, winningNumbers.size())
			.filter(i -> numbers.contains(winningNumbers.get(i)))
			.count();
	}

	@Override
	public String toString() {
		List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
		return sortedNumbers.toString();
	}
}
