package lotto.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	private static final String NUMBER_REGEX = "^[1-9]\\d*$";
	public static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

	private static final String NUMBERS_PATTERN_REGEX = "^([0-9]{1,2},){5}[0-9]{1,2}$";
	public static final Pattern LOTTO_NUMBERS_PATTERN = Pattern.compile(NUMBERS_PATTERN_REGEX);

	private ValidationUtils() {
	}

	public static boolean validateNumber(String number) {
		return isNotNull(number) && validatePattern(number, NUMBER_PATTERN);
	}

	private static boolean isNotNull(Object object) {
		return object != null;
	}

	private static boolean validatePattern(String string, Pattern pattern) {
		Matcher matcher = pattern.matcher(string);

		return matcher.find();
	}

	public static boolean validateNumbersPattern(String numbersPattern) {
		return isNotNull(numbersPattern) && validatePattern(numbersPattern, LOTTO_NUMBERS_PATTERN);
	}

	public static <T> boolean validateCollection(Collection<T> collection, int size) {
		return isNotNull(collection) && isSameSize(collection, size);
	}

	private static <T> boolean isSameSize(Collection<T> collection, int size) {
		return collection.size() == size;
	}

}
