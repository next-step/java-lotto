package stringaddcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Divider {
    private final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private List<String> DELIMITER = new ArrayList<>(Arrays.asList(",", ":"));
    private final int CUSTOM_DELIMITER_IDX = 1;
    private final int TARGET_NUM_IDX = 2;
    private Pattern pattern = Pattern.compile(CUSTOM_DELIMITER)

    List<String> splitInputByCustomDelimiterRule(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return Arrays.asList(matcher.group(CUSTOM_DELIMITER_IDX), matcher.group(TARGET_NUM_IDX));
        }
        return Arrays.asList(input);
    }

    void setCustomDelimiter(String customDelimiter) {
        this.DELIMITER.add(customDelimiter);
    }

    String[] getDividedInput(String num) {
        String delimiterRegex = "([" + String.join("", DELIMITER) + "])";
        return num.split(delimiterRegex);
    }

}
