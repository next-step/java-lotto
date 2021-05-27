package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.CollectionUtils.*;
import static lotto.util.ValidationUtils.*;

public class LottoTicketConverter {

	static final int LOTTO_NUMBER_COUNT = 6;

	static final String DELIMITER = ",";
	static final String INVALID_LOTTO_NUMBERS_FORMAT_MESSAGE = String.format("로또 숫자는 %d 자리입니다.",
			LOTTO_NUMBER_COUNT);
	public static final String INVALID_LOTTO_NUMBER_FORMAT_MESSAGE = String.format("로또 번호 문자열은 숫자 %d개와 %s만 가능합니다.",
			LOTTO_NUMBER_COUNT, DELIMITER);

	private LottoTicketConverter() {
	}

	public static LottoTicket convert(String numberString) {
		return new LottoTicket(parseLottoNumberSet(numberString));
	}

	private static Set<LottoNumber> parseLottoNumberSet(String numbersString) {
		validateNumberString(numbersString);

		return makeLottoNumberSet(makeIntegerList(makeStringArray(numbersString)));
	}

	private static void validateNumberString(String numbersString) {
		if (!validateNumbersPattern(numbersString)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT_MESSAGE);
		}
	}

	private static String[] makeStringArray(String numbersString) {
		return numbersString.split(DELIMITER);
	}

	private static List<Integer> makeIntegerList(String[] numbers) {
		return transform(Arrays.asList(numbers), new ArrayList<>(), Integer::parseInt);
	}

	private static Set<LottoNumber> makeLottoNumberSet(List<Integer> numberList) {
		Set<LottoNumber> lottoNumberSet = new HashSet<>(transform(numberList, new ArrayList<>(), LottoNumber::of));

		validate(lottoNumberSet);

		return lottoNumberSet;
	}

	private static void validate(Set<LottoNumber> lottoNumbers) {
		if (!validateCollection(lottoNumbers, LOTTO_NUMBER_COUNT)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_FORMAT_MESSAGE);
		}
	}
}
