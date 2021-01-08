package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.Message;

public class LottoNumberUtils {
	private static final String COMMA = ",";

	public static List<LottoNumber> mapToListByComma(String numbers) {
		ValidationUtils.validateEmpty(numbers);

		return mapToList(splitByComma(numbers));
	}

	private static String[] splitByComma(String numbers) {
		return numbers.split(COMMA);
	}

	private static List<LottoNumber> mapToList(String[] strings) {
		return Arrays.stream(strings)
			.map(String::trim)
			.map(LottoNumberUtils::parseInt)
			.map(LottoNumber::of)
			.collect(Collectors.toList());
	}

	private static int parseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER);
		}
	}
}
