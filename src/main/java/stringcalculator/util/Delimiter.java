package stringcalculator.util;

import static stringcalculator.domain.Validator.validatePositiveNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static String[] DEFAULT_DELIMITER = new String[]{",", ":"};

    private static final List<String> delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITER));

    private Delimiter() {
    }

    public static String findExpression(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            addCustomDelimiter(matcher.group(1));
            return matcher.group(2);
        }
        return input;
    }

    private static void addCustomDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public static List<Integer> extractNumberFromExpression(String input) {
        return convertOperandType(Arrays.asList(input.split(String.join("|", delimiters))));
    }

    private static List<Integer> convertOperandType(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        tokens.forEach(
            token -> numbers.add(validatePositiveNumber(token))
        );
        return numbers;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }
}
