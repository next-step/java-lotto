package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private final List<String> DELIMITER = Arrays.asList("\\:", "\\,");
    private final String JOIN_STR = "|";
    private String customDelimiter = "";
    private String userNumber = "";
    private String delimiter = "";

    public Separator(String text) {
        userNumber = text;
        extractCustomDelimiter(text);
        delimiter = createDelimiterRegex();
    }

    public void extractCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            customDelimiter = m.group(1);
            userNumber = m.group(2);
        }
    }

    private String createDelimiterRegex() {
        String delimiterString = String.join(JOIN_STR, DELIMITER);
        if (!customDelimiter.equals("")) {
            delimiterString += JOIN_STR + "\\" + customDelimiter;
        }
        return delimiterString;
    }

    public List<String> split() {
        return Arrays.stream(userNumber.split(delimiter))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
