package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValueProcessing {
    private static final String SPLIT_CRITERIA = ",|:";
    private static final String PATTERN_CRITERIA = "//(.)\n(.*)";
    private static final int GROUP_INDEX1 = 1;
    private static final int GROUP_INDEX2 = 2;
    private static Pattern pattern = Pattern.compile(PATTERN_CRITERIA);

    public static int calculateInputValue(String inputValue) {
        if (inputValue == null || inputValue.isEmpty())
            return 0;
        if (inputValue.startsWith("//")) {
            return new Numbers(checkCustomDelimiter(inputValue)).sum();
        }

        return new Numbers(inputValue.split(SPLIT_CRITERIA)).sum();
    }

    public static String[] checkCustomDelimiter(String inputValue) {
        Matcher m = pattern.matcher(inputValue);
        if (m.find()) {
            String customDelimiter = m.group(GROUP_INDEX1);
            return m.group(GROUP_INDEX2).split(customDelimiter);
        }
        return new String[0];
    }

}
