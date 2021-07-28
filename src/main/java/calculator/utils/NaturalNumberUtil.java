package calculator.utils;

import java.util.regex.Pattern;

import static calculator.utils.StringUtil.isNullOrEmpty;

public class NaturalNumberUtil {

    private static final Pattern NATURAL_NUMBER_PATTERN = Pattern.compile("\\d+");

    public static boolean isNotNaturalNumber(String numberString) {
        return !isNaturalNumber(numberString);
    }

    private static boolean isNaturalNumber(String numberString) {
        if (isNullOrEmpty(numberString)) {
            return false;
        }

        return NATURAL_NUMBER_PATTERN.matcher(numberString).matches();
    }

}
