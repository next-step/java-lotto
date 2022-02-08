package stringcalculator.domain;

import static stringcalculator.domain.Validator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private static final int DELIMITER_GROUP = 1;
    private static final int EXPRESSION_GROUP = 2;

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String[] DEFAULT_DELIMITER = new String[]{",", ":"};

    private static final List<String> delimiters = new ArrayList<>(
        Arrays.asList(DEFAULT_DELIMITER));

    public Delimiter() {
    }

    public static String findExpression(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            addCustomDelimiter(matcher.group(DELIMITER_GROUP));
            return matcher.group(EXPRESSION_GROUP);
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
            token -> numbers.add(Validator.validatePositiveNumber(token))
        );
        return numbers;
    }
}
