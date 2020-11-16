package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringPlusCalculator {

    private static final String EXPRESSION_RULE = ",|:";
    private static final String NUMBER = "^[0-9]*$";

    private static final Pattern CUSTOM_EXPRESSION_RULE = Pattern.compile("//(.)\n(.*)");

    private StringPlusCalculator() {
    }

    public static int stringSplitToSum(final String inputData) {
        if (isEmptyOrNull(inputData)) {
            return 0;
        }
        String[] splitArray = inputSplit(inputData);
        return Arrays.stream(Stream.of(splitArray)
                .mapToInt(number -> {
                    validateInputData(number);
                    return Integer.parseInt(number);
                })
                .toArray()).sum();
    }

    private static String[] inputSplit(final String inputData) {

        Matcher matcher = CUSTOM_EXPRESSION_RULE.matcher(inputData);

        if (matcher.find()) {
            String expression = matcher.group(1);
            String[] result = matcher.group(2).split(expression);
            return result;
        }
        return inputData.split(EXPRESSION_RULE);
    }

    private static boolean isEmptyOrNull(final String inputData) {
        return inputData == null || inputData.trim().length() == 0;
    }

    private static void validateInputData(final String validData) {
        if (!Pattern.matches(NUMBER, validData) || Integer.parseInt(validData) < 0) {
            throw new NotValidNumberException();
        }
    }

}
