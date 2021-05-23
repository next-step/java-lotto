package lotto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	private static final String NUMBER_REGEX = "^([0-9]{1,2},){5}[0-9]{1,2}$";
	private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

	public static boolean validateLottoNumberPattern(String numberString) {
		if (numberString == null) {
			return false;
		}

		Matcher matcher = LOTTO_NUMBER_PATTERN.matcher(numberString);

		return matcher.find();
	}

}
