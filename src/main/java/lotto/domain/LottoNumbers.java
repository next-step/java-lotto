package lotto.domain;

import java.util.List;

import lotto.exception.ErrorMessage;
import lotto.exception.InvalidLottoNumberQuantityException;

public class LottoNumbers {

	private final List<Integer> numbers;

	private LottoNumbers(List<Integer> numbers) {
		if (!isValidNumbersSize(numbers)) {
			throw new InvalidLottoNumberQuantityException(ErrorMessage.LOTTO_NUMBERS_QUANTITY_MUST_BE_SIX);
		}
		this.numbers = numbers;
	}

	public static LottoNumbers of(List<Integer> numbers) {
		return new LottoNumbers(numbers);
	}

	private boolean isValidNumbersSize(List<Integer> numbers) {
		return numbers.size() == Lotto.LOTTO_NUMBER_QUANTITY;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
