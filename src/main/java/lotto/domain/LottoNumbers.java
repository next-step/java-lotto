package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lotto.exception.InvalidLottoNumberSizeException;

public class LottoNumbers {

	private static final int VALID_LOTTO_NUMBERS_COUNT = 6;

	private final List<Integer> numbers;

	private LottoNumbers(List<Integer> numbers) {
		validateLottoNumbers(numbers);
		this.numbers = numbers;
	}

	public static LottoNumbers from(List<Integer> numbers) {
		return new LottoNumbers(numbers.stream()
									.distinct()
									.collect(collectingAndThen(toList(), Collections::unmodifiableList)));
	}

	public LottoTicket toLottoTicket() {
		return LottoTicket.from(numbers);
	}

	private void validateLottoNumbers(List<Integer> lottoNumbers) {
		if (hasInvalidSize(lottoNumbers)) {
			throw new InvalidLottoNumberSizeException(lottoNumbers.size());
		}
	}

	private boolean hasInvalidSize(List<Integer> lottoNumbers) {
		return lottoNumbers.size() != VALID_LOTTO_NUMBERS_COUNT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumbers that = (LottoNumbers) o;
		return Objects.equals(numbers, that.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
