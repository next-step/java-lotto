package lotto.domain;

import static lotto.util.CollectionUtils.*;
import static lotto.util.ValidationUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoTicket {

	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final String DELIMITER = ",";
	private static final String INVALID_LOTTO_NUMBERS_MESSAGE = "로또 숫자가 유효하지 않습니다.";
	private static final String INVALID_LOTTO_NUMBER_TEXT_FORMAT_MESSAGE = "로또 번호 문자열이 형식에 맞지 않습니다.";

	private final Set<LottoNumber> lottoNumbers;

	LottoTicket(Set<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);

		this.lottoNumbers = lottoNumbers;
	}

	private void validate(Set<LottoNumber> lottoNumbers) {
		if (!validateCollection(lottoNumbers, LOTTO_NUMBER_COUNT)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
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
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_TEXT_FORMAT_MESSAGE);
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

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

}
