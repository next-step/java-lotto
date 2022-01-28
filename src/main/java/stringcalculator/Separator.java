package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
//    private final List<String> DELIMITER = Arrays.asList(";", ",");
//    private final String JOIN_STR = "|";

    public String extractCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
        }
        return customDelimiter;
    }

    public String createDelimiterRegex(String customDelimiter) {
        String delimiter = ":|,";
        if (!customDelimiter.equals("")) {
            delimiter += "|" + customDelimiter;
        }
        return delimiter;
    }

    public List<String> split(String userInput, String customDelimiter) {
        String delimiterRegex = createDelimiterRegex(customDelimiter);
        String[] numbers = userInput.split(delimiterRegex);
        return Arrays.asList(numbers);
    }
}
