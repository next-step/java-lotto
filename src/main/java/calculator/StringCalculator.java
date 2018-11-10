package calculator;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static spark.utils.StringUtils.isEmpty;

public class StringCalculator {

    private static final int PATTERN_INDEX = 5;
    private static final int PATTERN_SPLIT_START_INDEX = 2;
    private static final int PATTERN_SPLIT_END_INDEX = 3;

    public static int add(String stringNumber) throws RuntimeException {
        if(isEmpty(stringNumber)) {
            return 0;
        }

        String[] numbers = getSplitNumber(stringNumber);
        return getAddResult(numbers);
    }

    private static String[] getSplitNumber(String stringNumber)  {
        if(isCustomPattern(stringNumber)) {
            return getPatternStringNumber(stringNumber).split(Pattern.quote(getCustomPattern(stringNumber)));
        }

        return stringNumber.split(",|:");
    }

    private static String getPatternStringNumber(String stringNumber) {
        return stringNumber.substring(PATTERN_INDEX);
    }

    private static String getCustomPattern(String stringNumber) {
        return stringNumber.substring(PATTERN_SPLIT_START_INDEX, PATTERN_SPLIT_END_INDEX);
    }

    private static boolean isCustomPattern(String stringNumber) {
        return stringNumber.startsWith("//") || stringNumber.contains("\n");
    }

    private static int getAddResult(String[] numbers) {
        int result = 0;
        for(int i = 0; i < numbers.length; i++) {
            result += parseInt(numbers[i]);
        }
        checkNumber(result);

        return result;
    }

    private static void checkNumber(int result) {
        if (result < 0) {
            throw new RuntimeException();
        }
    }
}