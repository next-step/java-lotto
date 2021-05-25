package lotto;

import exception.LottoException;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static type.LottoExceptionType.WRONG_LOTTO_NUMBER;

public final class LottoNumbers {
	private final static int LOTTO_NUMBER_COUNT = 6;

	private final Set<LottoNumber> lottoNumbers;

	private LottoNumbers(){
		throw new UnsupportedOperationException();
	}

	public LottoNumbers(List<Integer> numbers) {
		if (numbers == null) {
			throw LottoException.of(WRONG_LOTTO_NUMBER);
		}
		this.lottoNumbers = Collections.unmodifiableSet(makeLottoNumbers(numbers));
	}

	private Set<LottoNumber> makeLottoNumbers(final List<Integer> numbers) {
		Set<LottoNumber> lottoNumbers = numbers.stream()
											   .map(LottoNumber::new)
											   .sorted()
											   .collect(Collectors.toCollection(LinkedHashSet::new));
		if (isValidLottoNumberCount(lottoNumbers) == false) {
			throw LottoException.of(WRONG_LOTTO_NUMBER);
		}
		return lottoNumbers;
	}

	public int matches(final LottoNumbers parameter) {
		int sameNumber = 0;
		for (LottoNumber number : parameter.lottoNumbers) {
			sameNumber += match(number);
		}
		return sameNumber;
	}

	private int match(final LottoNumber number) {
		if (this.lottoNumbers.contains(number)) {
			return 1;
		}
		return 0;
	}

	public boolean isValidLottoNumberCount(final Set<LottoNumber> lottoNumbers) {
		return lottoNumbers.size() == LOTTO_NUMBER_COUNT;
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
