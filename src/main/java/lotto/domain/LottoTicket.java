package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

import lotto.exception.InvalidLottoNumbersSizeException;

public class LottoTicket {

	private static final int VALID_LOTTO_NUMBERS_SIZE = 6;

	private final List<LottoNumber> lottoNumbers;

	private LottoTicket(List<LottoNumber> numbers) {
		validateLottoNumbers(numbers);
		this.lottoNumbers = numbers;
	}

	public static LottoTicket from(List<Integer> numbers) {
		return new LottoTicket(numbers.stream()
								.distinct()
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

	public LottoPrize compareTo(LottoTicket lottoTicket, LottoNumber bonusNumber) {
		int count = (int) lottoNumbers.stream()
						.filter(lottoTicket.lottoNumbers::contains)
						.count();

		return LottoPrize.fromMatchCount(count, lottoNumbers.contains(bonusNumber));
	}

	public int matchCount(LottoTicket winningTicket) {
		return (int) lottoNumbers.stream()
						.filter(winningTicket.lottoNumbers::contains)
						.count();
	}

	public boolean contains(LottoNumber bonusNumber) {
		return lottoNumbers.contains(bonusNumber);
	}

	private static void validateLottoNumbers(List<LottoNumber> numbers) {
		if (hasInvalidSize(numbers)) {
			throw new InvalidLottoNumbersSizeException(numbers.size());
		}
	}

	private static boolean hasInvalidSize(List<LottoNumber> numbers) {
		return numbers.size() != VALID_LOTTO_NUMBERS_SIZE;
	}
}
