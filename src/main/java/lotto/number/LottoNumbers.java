package lotto.number;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

	private static final int LOTTO_NUMBER_SIZE = 6;
	private static final String LOTTO_VALIDATE_SIZE_WRONG = "lottoNumbers size must be %s";
	private static final String LOTTO_VALIDATE_DUPLICATED = "lottoNumber is duplicated";

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumberList) {
		this.lottoNumbers = toSortedUnmodifiableList(lottoNumberList);
		validateNumbers(this.lottoNumbers);
	}

	private static List<LottoNumber> toSortedUnmodifiableList(List<LottoNumber> lottoNumberList) {
		List<LottoNumber> sortList = new ArrayList<>(lottoNumberList);
		Collections.sort(sortList);
		return Collections.unmodifiableList(sortList);
	}

	private static void validateNumbers(List<LottoNumber> lottoNumbers) throws IllegalArgumentException {
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			String msg = String.format(LOTTO_VALIDATE_SIZE_WRONG, LOTTO_NUMBER_SIZE);
			throw new IllegalArgumentException(msg);
		}

		validateDuplicated(lottoNumbers);
	}

	private static void validateDuplicated(List<LottoNumber> lottoNumbers) {
		Set<LottoNumber> uniqueNumbers = new HashSet<>(lottoNumbers);
		if (uniqueNumbers.size() != lottoNumbers.size()) {
			throw new IllegalArgumentException(LOTTO_VALIDATE_DUPLICATED);
		}
	}

	public List<LottoNumber> getMatchedLottoNumbers(LottoNumbers otherLottoNumbers) {
		return this.lottoNumbers.stream()
				.filter(number -> hasEqualNumber(otherLottoNumbers, number))
				.collect(Collectors.toList());
	}

	private boolean hasEqualNumber(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
		return lottoNumbers.lottoNumbers.stream()
				.anyMatch(streamNumber -> streamNumber.equals(lottoNumber));
	}
}
