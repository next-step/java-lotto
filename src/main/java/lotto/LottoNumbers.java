package lotto;

import exception.LottoException;
import type.LottoRewardType;

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

	public LottoRewardType result(final LottoNumbers winningLottoNumber, final LottoNumber bonusNumber) {
		return LottoRewardType.of(matches(winningLottoNumber),
								  contains(bonusNumber));
	}


	private int matches(final LottoNumbers winningLottoNumber) {
		return winningLottoNumber.lottoNumbers.stream()
											  .filter(this::contains)
											  .map(notUsed -> 1)
											  .reduce(0, Integer::sum);
	}

	private boolean contains(final LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public boolean isValidLottoNumberCount(final Set<LottoNumber> lottoNumbers) {
		return lottoNumbers.size() == LOTTO_NUMBER_COUNT;
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
