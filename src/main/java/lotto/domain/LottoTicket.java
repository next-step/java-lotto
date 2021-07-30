package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

import lotto.exception.InvalidLottoNumbersSizeException;

public class LottoTicket {

	public static final int VALID_LOTTO_NUMBERS_SIZE = 6;
	private final List<LottoNumber> lottoNumbers;

	private LottoTicket(List<LottoNumber> numbers) {
		this.lottoNumbers = numbers;
	}

	public static LottoTicket from(List<Integer> numbers) {
		validateLottoNumbers(numbers);
		return new LottoTicket(numbers.stream()
								.map(LottoNumber::new)
								.collect(collectingAndThen(toList(), Collections::unmodifiableList)));
	}

	public static LottoTicket from(WinningLottoNumbers winningNumbers) {
		return from(winningNumbers.getWinningNumbers());
	}

	public List<Integer> getNumbers() {
		return lottoNumbers.stream()
				.map(LottoNumber::getNumber)
				.sorted()
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	public LottoPrize compareTo(LottoTicket lottoTicket) {
		int count = (int) lottoNumbers.stream()
						.filter(lottoTicket.lottoNumbers::contains)
						.count();
		return LottoPrize.fromMatchCount(count);
	}

	private static void validateLottoNumbers(List<Integer> numbers) {
		if (hasInvalidSize(numbers)) {
			throw new InvalidLottoNumbersSizeException();
		}
	}

	private static boolean hasInvalidSize(List<Integer> numbers) {
		return numbers.size() != VALID_LOTTO_NUMBERS_SIZE;
	}
}
