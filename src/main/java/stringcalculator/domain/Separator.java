package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private final static List<String> DELIMITER = Arrays.asList("\\:", "\\,");
    private final static String JOIN_STR = "|";
    private String customDelimiter = "";
    private String userNumber = "";
    private String delimiter = "";

    public Separator(final String text) {
        userNumber = text;
        extractCustomDelimiter(text);
        delimiter = createDelimiterRegex();
    }

    private void extractCustomDelimiter(final String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            customDelimiter = m.group(1);
            userNumber = m.group(2);
        }
    }

    private String createDelimiterRegex() {
        String delimiterString = String.join(JOIN_STR, DELIMITER);
        if (!"".equals(customDelimiter)) {
            delimiterString += JOIN_STR + "\\" + customDelimiter;
        }
        return delimiterString;
    }

    public List<String> split() {
        String[] numbers = userNumber.split(delimiter);
        return Arrays.asList(numbers);
    }

    public List<Integer> splitAsInteger() {
        String[] numbers = userNumber.split(delimiter);
        return Arrays.stream(numbers).map(number -> Integer.parseInt(number))
            .collect(Collectors.toList());
    }
}
