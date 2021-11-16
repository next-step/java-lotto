package step1;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final String STANDARD_REGEX = ",|:";
    private static final String CUSTOM_CHECK_REGEX = "//(.)\n(.*)";
    private static final String CUSTOM_REGEX = ",|:|\\%s";
    private static final int CUSTOM_DELIM = 1;
    private static final int CUSTOM_EXPRESSION = 2;

    private final List<Number> numbers;

    public Expression(final String input) {
        numbers = new LinkedList<>();
        if (isValid(input)) {
            String[] stringNums = generateStringNums(input);
            initNumbers(stringNums);
        }
    }

    private boolean isValid(String input) {
        return (input != null) && (!input.isEmpty());
    }

    private String[] generateStringNums(String input) {
        String[] stringNums = input.split(STANDARD_REGEX);

        Matcher matcher = Pattern.compile(CUSTOM_CHECK_REGEX).matcher(input);
        if (matcher.find()) {
            String customDelim = matcher.group(CUSTOM_DELIM);
            String regex = String.format(CUSTOM_REGEX, customDelim);
            stringNums = matcher.group(CUSTOM_EXPRESSION).split(regex);
        }

        return stringNums;
    }

    private void initNumbers(String[] stringNums) {
        for (String num : stringNums) {
            numbers.add(new Number(num));
        }
    }

    public boolean hasNextNumber() {
        return !numbers.isEmpty();
    }

    public Number nextNumber() {
        return numbers.remove(0);
    }
}
