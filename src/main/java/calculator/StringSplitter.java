package calculator;

import util.NumberUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final Pattern customSeparatorPattern = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final int SEPARATOR_PART = 1;
    private static final int INPUT_PART = 2;

    private StringSplitter() {}

    public static String[] getSplitInput(String input) {
        String[] splitInput = split(input);
        if(containNegativeInt(splitInput)) {
            throw new RuntimeException("음수는 입력값에 포함되면 안됩니다.");
        }
        return splitInput;
    }

    private static boolean containNegativeInt(String[] splitInput) {
        return Arrays.stream(splitInput).anyMatch(NumberUtils::isNegativeInt);
    }

    private static String[] split(String input) {
        Matcher m = customSeparatorPattern.matcher(input);
        if (m.find()) {
            String customSeparator = m.group(SEPARATOR_PART) + "|" + DEFAULT_SEPARATOR;
            return m.group(INPUT_PART).split(customSeparator);
        }
        return input.split(DEFAULT_SEPARATOR);
    }
}