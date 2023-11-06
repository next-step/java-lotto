package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    public static final Pattern NON_BLANK_NON_NUMBER_PATTERN = Pattern.compile("[^\\s\\d]");

    public static List<Integer> splitNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    public static List<String> splitOperation(String input) {
        List<String> operations = new ArrayList<>();
        Matcher matcher = NON_BLANK_NON_NUMBER_PATTERN.matcher(input);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        return operations;
    }
}
