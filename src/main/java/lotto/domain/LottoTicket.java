package lotto.domain;

import static lotto.util.CollectionUtils.*;
import static lotto.util.ValidationUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoTicket {

	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final String DELIMITER = ",";
	private static final String INVALID_LOTTO_NUMBERS_MESSAGE = "로또 숫자는 %d 자리입니다.";
	private static final String INVALID_LOTTO_NUMBER_TEXT_FORMAT_MESSAGE = "로또 번호 문자열은 숫자와 %s만 가능합니다.";

	private final Set<LottoNumber> lottoNumbers;

	static int compare(LottoTicket userLottoTicket, LottoTicket winningLottoTicket) {
		return userLottoTicket.compare(winningLottoTicket.lottoNumbers);
	}

	LottoTicket(Set<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);

		this.lottoNumbers = lottoNumbers;
	}

	private void validate(Set<LottoNumber> lottoNumbers) {
		if (!validateCollection(lottoNumbers, LOTTO_NUMBER_COUNT)) {
			throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBERS_MESSAGE, LOTTO_NUMBER_COUNT));
		}
	}

	public LottoTicket(String numbersString) {
		lottoNumbers = parseLottoNumberSet(numbersString);
	}

	private Set<LottoNumber> parseLottoNumberSet(String numbersString) {
		validateNumberString(numbersString);

		return makeLottoNumberSet(makeIntegerList(makeStringArray(numbersString)));
	}

	private void validateNumberString(String numbersString) {
		if (!validateNumbersPattern(numbersString)) {
			throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_TEXT_FORMAT_MESSAGE, DELIMITER));
		}
	}

	private String[] makeStringArray(String numbersString) {
		return numbersString.split(DELIMITER);
	}

	private List<Integer> makeIntegerList(String[] numbers) {
		List<Integer> numberList = new ArrayList<>(LOTTO_NUMBER_COUNT);
		transform(Arrays.asList(numbers), numberList, Integer::parseInt);

		return numberList;
	}

	private Set<LottoNumber> makeLottoNumberSet(List<Integer> numberList) {
		Set<LottoNumber> lottoNumberSet = new HashSet<>(LOTTO_NUMBER_COUNT);
		transform(numberList, lottoNumberSet, LottoNumber::of);

		validateLottoNumberSet(lottoNumberSet);

		return lottoNumberSet;
	}

	private void validateLottoNumberSet(Set<LottoNumber> lottoNumberList) {
		if (!validateCollection(lottoNumberList, LOTTO_NUMBER_COUNT)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
		}
	}

	int compare(Set<LottoNumber> lottoNumberSet) {
		Set<LottoNumber> targetLottoNumberSet = new HashSet<>(lottoNumberSet);
		validateLottoNumberSet(targetLottoNumberSet);

		targetLottoNumberSet.retainAll(this.lottoNumbers);

		return targetLottoNumberSet.size();
	}

	boolean matchNumber(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		List<LottoNumber> list = new ArrayList<>(lottoNumbers);
		Collections.sort(list);

		return list.toString();
	}

}
