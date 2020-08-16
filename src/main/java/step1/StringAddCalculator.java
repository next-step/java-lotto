package step1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_DELIMITER = ",:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_OPERAND_INDEX = 2;
    private static final Function<String, String> GET_REGEX_TO_VALIDATE = delimiter -> "[^0-9" + delimiter + "]";
    private static final Function<String, String> GET_REGEX_TO_SPLIT = delimiter -> "[" + delimiter + "]";

    private static boolean isNull(String operand) {
        return operand == null;
    }

    private static boolean isEmpty(String operand) {
        return EMPTY_STRING.equals(operand);
    }

    private static void validate(String operand, String delimiter) throws RuntimeException {
        Matcher validator = Pattern.compile(GET_REGEX_TO_VALIDATE.apply(delimiter)).matcher(operand);
        if (validator.find()) {
            throw new RuntimeException();
        }
    }

    private static int splitAndSum(String operand, String delimiter) throws RuntimeException {
        if (isEmpty(operand)) {
            return 0;
        }
        validate(operand, delimiter);
        String[] tokens = operand.split(GET_REGEX_TO_SPLIT.apply(delimiter));
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .reduce(Integer::sum)
                .orElseThrow(RuntimeException::new);
    }

    public static int splitAndSum(String operand) throws RuntimeException {
        if (isNull(operand)) {
            return 0;
        }
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(operand);
        if (matcher.find()) {
            return splitAndSum(matcher.group(CUSTOM_OPERAND_INDEX), matcher.group(CUSTOM_DELIMITER_INDEX));
        }
        return splitAndSum(operand, DEFAULT_DELIMITER);
    }
}
