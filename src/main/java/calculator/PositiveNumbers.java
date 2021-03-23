package calculator;

import common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PositiveNumbers {

    private static final String ZERO = "0";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CALCULATE_TARGET_INDEX = 2;

    private final List<PositiveNumber> positiveNumberList;

    public PositiveNumbers(String text) {
        this.positiveNumberList = parsePositiveNumberList(createCalculateTarget(text));
    }

    private String[] createCalculateTarget(String text) {
        if(StringUtils.isBlank(text)) {
            return new String[] {ZERO};
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            return m.group(CALCULATE_TARGET_INDEX).split(customDelimiter);
        }

        return DefaultDelimiter.split(text);
    }

    private List<PositiveNumber> parsePositiveNumberList(String[] textArray) {
        return Arrays.stream(textArray).map(PositiveNumber::new).collect(Collectors.toList());
    }

    public int sum() {
        int sum = 0;
        for (PositiveNumber positiveNumber : positiveNumberList) {
            sum+=positiveNumber.getPositiveNumber();
        }
        return sum;
    }
}
