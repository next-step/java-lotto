package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class LottoNumbers {

	private static final int LOTTO_NUMBER_SIZE = 6;
	private static final String LOTTO_VALIDATE_SIZE_WRONG = "lottoNumbers size must be %s";
	private static final String LOTTO_VALIDATE_DUPLICATED = "lottoNumber is duplicated";

	private final List<LottoNumber> lottoNumbers;

	LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	static void validateNumbers(List<Integer> lottoNumbers) throws IllegalArgumentException {
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			String msg = String.format(LOTTO_VALIDATE_SIZE_WRONG, LOTTO_NUMBER_SIZE);
			throw new IllegalArgumentException(msg);
		}

		validateDuplicated(lottoNumbers);
	}

	private static void validateDuplicated(List<Integer> lottoNumbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
		if (uniqueNumbers.size() != lottoNumbers.size()) {
			throw new IllegalArgumentException(LOTTO_VALIDATE_DUPLICATED);
		}
	}

	List<LottoNumber> getMatchedLottoNumbers(LottoNumbers otherLottoNumbers) {
		return this.getLottoNumbers().stream()
				.filter(number -> hasEqualNumber(otherLottoNumbers, number))
				.collect(Collectors.toList());
	}

	private boolean hasEqualNumber(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
		return lottoNumbers.getLottoNumbers().stream()
				.anyMatch(streamNumber -> streamNumber.equals(lottoNumber));
	}

	private List<LottoNumber> getLottoNumbers() {
		return this.lottoNumbers;
	}
}
