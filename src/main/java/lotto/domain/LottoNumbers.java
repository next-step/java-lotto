package lotto.domain;

import java.util.List;

import lotto.exception.ErrorMessage;
import lotto.exception.InvalidLottoNumberQuantityException;

public class LottoNumbers {

	private final List<LottoNum> numbers;

	private LottoNumbers(List<LottoNum> numbers) {
		if (!isValidNumbersSize(numbers)) {
			throw new InvalidLottoNumberQuantityException(ErrorMessage.LOTTO_NUMBERS_QUANTITY_MUST_BE_SIX);
		}
		this.numbers = numbers;
	}

	public static LottoNumbers of(List<LottoNum> numbers) {
		return new LottoNumbers(numbers);
	}

	private boolean isValidNumbersSize(List<LottoNum> numbers) {
		return numbers.size() == Lotto.LOTTO_NUMBER_QUANTITY;
	}

	public List<LottoNum> getNumbers() {
		return numbers;
	}
}
