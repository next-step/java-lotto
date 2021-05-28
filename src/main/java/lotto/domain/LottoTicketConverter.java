package lotto.domain;

import static lotto.util.CollectionUtils.*;
import static lotto.util.ValidationUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
		return makeLottoNumberSet(makeIntegerList(makeStringArray(validNumberString(numbersString))));
	}

	private static String validNumberString(String numbersString) {
		return Optional.ofNullable(numbersString)
			.filter(str -> LOTTO_NUMBERS_PATTERN.matcher(str)
				.find())
			.orElseThrow(() -> new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT_MESSAGE));
	}

	private static String[] makeStringArray(String numbersString) {
		return numbersString.split(DELIMITER);
	}

	private static List<Integer> makeIntegerList(String[] numbers) {
		return transform(Arrays.asList(numbers), new ArrayList<>(), Integer::parseInt);
	}

	private static Set<LottoNumber> makeLottoNumberSet(List<Integer> numberList) {
		Set<LottoNumber> lottoNumberSet = new HashSet<>(
			transform(validNumberList(numberList), new ArrayList<>(), LottoNumber::of));

		return validLottoNumbers(lottoNumberSet);
	}

	private static Set<LottoNumber> validLottoNumbers(Set<LottoNumber> lottoNumberSet) {
		return Optional.of(lottoNumberSet)
			.filter(set -> set.size() == LOTTO_NUMBER_COUNT)
			.orElseThrow(() -> new IllegalArgumentException(INVALID_LOTTO_NUMBERS_FORMAT_MESSAGE));
	}

	private static List<Integer> validNumberList(List<Integer> numberList) {
		return Optional.ofNullable(numberList)
			.orElse(new ArrayList<>());
	}

}
