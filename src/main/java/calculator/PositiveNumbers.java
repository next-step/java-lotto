package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositiveNumbers {

    private static final String FIRST_DEFAULT_DELIMITER = ":";
    private static final String SECOND_DEFAULT_DELIMITER = ",";

    private final List<PositiveNumber> positiveNumberList;

    public PositiveNumbers(String text) {
        this.positiveNumberList = parsePositiveNumberList(createCalculateTarget(text));
    }

    private String[] createCalculateTarget(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.replace(FIRST_DEFAULT_DELIMITER, SECOND_DEFAULT_DELIMITER).split(SECOND_DEFAULT_DELIMITER);
    }

    private List<PositiveNumber> parsePositiveNumberList(String[] textArray) {
        List<PositiveNumber> positiveNumberList = new ArrayList<>();
        for (String text : textArray) {
            positiveNumberList.add(new PositiveNumber(text));
        }
        return positiveNumberList;
    }

    public int sum() {
        int sum = 0;
        for (PositiveNumber positiveNumber : positiveNumberList) {
            sum+=positiveNumber.getPositiveNumber();
        }
        return sum;
    }
}
