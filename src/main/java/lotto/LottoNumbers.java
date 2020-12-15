package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoNumbers {

	private static final int LOTTO_NUMBER_SIZE = 6;
	private static final int LOTTO_NUMBER_RANGE_INCLUSIVE_MIN = 1;
	private static final int LOTTO_NUMBER_RANGE_INCLUSIVE_MAX = 45;
	private static final String LOTTO_VALIDATE_SIZE_WRONG = "lottoNumbers size must be %s";
	private static final String LOTTO_VALIDATE_RANGE_WRONG = "each lottoNumber range must in 1~45";
	private static final String LOTTO_VALIDATE_DUPLICATED = "lottoNumber is duplicated";

	static void validateNumbers(List<Integer> lottoNumbers) throws IllegalArgumentException {
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			String msg = String.format(LOTTO_VALIDATE_SIZE_WRONG, LOTTO_NUMBER_SIZE);
			throw new IllegalArgumentException(msg);
		}

		lottoNumbers.forEach(LottoNumbers::validateRange);
		validateDuplicated(lottoNumbers);
	}

	private static void validateRange(int number) {
		if (number < LOTTO_NUMBER_RANGE_INCLUSIVE_MIN || number > LOTTO_NUMBER_RANGE_INCLUSIVE_MAX) {
			throw new IllegalArgumentException(LOTTO_VALIDATE_RANGE_WRONG);
		}
	}

	private static void validateDuplicated(List<Integer> lottoNumbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
		if (uniqueNumbers.size() != lottoNumbers.size()) {
			throw new IllegalArgumentException(LOTTO_VALIDATE_DUPLICATED);
		}
	}
}
