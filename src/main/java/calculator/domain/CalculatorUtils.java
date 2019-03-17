package calculator.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtils {

    private static final int CUSTOM_SEPARATOR_START_POINT = 2;
    private static final int CUSTOM_SEPARATOR_END_POINT = 3;
    private static final int CUSTOM_NUMBER_START_POINT = 5;

    public static List<String> splitInputValue(String inputValue, String separator) {
        isBlank(inputValue);

        if (StringUtils.isBlank(separator)) {
            return Arrays.asList(inputValue.split("[,:]"));
        }

        return Arrays.asList(inputValue.substring(CUSTOM_NUMBER_START_POINT).split(separator));
    }

    public static void isBlank(String inputValue) throws IllegalArgumentException {
        if (StringUtils.isBlank(inputValue)) {
            throw new IllegalArgumentException("입력값이 없음");
        }
    }

    public static String checkCustomSeparator(String inputValue) {
        Pattern pattern = Pattern.compile("^//.\\n*");
        Matcher matcher = pattern.matcher(inputValue.trim());

        if (matcher.find()) {
            return inputValue.substring(CUSTOM_SEPARATOR_START_POINT, CUSTOM_SEPARATOR_END_POINT);
        }

        return "";
    }
}
