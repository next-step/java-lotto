package lotto;

import exception.LottoException;
import type.LottoRewardType;

import java.util.*;
import java.util.stream.Collectors;

import static type.LottoExceptionType.WRONG_LOTTO_NUMBER;

public final class LottoNumbers {
	private final static int LOTTO_NUMBER_COUNT = 6;

	private final Set<LottoNumber> lottoNumbers;

	private LottoNumbers() {
		throw new UnsupportedOperationException();
	}

	public LottoNumbers(final List<Integer> numbers) {
		checkNull(numbers);
		Set<LottoNumber> lottoNumbers = makeLottoNumbers(numbers);
		checkLottoNumberCount(lottoNumbers);
		this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
	}

	private void checkNull(final List<Integer> numbers) {
		if (Objects.isNull(numbers)) {
			throw LottoException.of(WRONG_LOTTO_NUMBER);
		}
	}

	private Set<LottoNumber> makeLottoNumbers(final List<Integer> numbers) {
		return numbers.stream()
					  .map(LottoNumber::new)
					  .sorted()
					  .collect(Collectors.toCollection(LinkedHashSet::new));
	}

	public LottoRewardType result(final WinningLottoNumbers winningLottoNumbers) {
		return LottoRewardType.of(matches(winningLottoNumbers.winningLottoNumbers()),
								  contains(winningLottoNumbers.bonusNumber()));
	}


	private int matches(final LottoNumbers winningLottoNumber) {
		return winningLottoNumber.lottoNumbers.stream()
											  .filter(this::contains)
											  .map(notUsed -> 1)
											  .reduce(0, Integer::sum);
	}

	public boolean contains(final LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public void checkLottoNumberCount(final Set<LottoNumber> lottoNumbers) {
		if(lottoNumbers.size() != LOTTO_NUMBER_COUNT){
			throw LottoException.of(WRONG_LOTTO_NUMBER);
		}
	}

	public Set<LottoNumber> lottoNumbers() {
		return this.lottoNumbers;
	}
}
