import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITER = ",|:";
    private static final String REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String formula) {
        if (isNullOrEmpty(formula)) {
            return 0;
        }

        String[] numbers = split(formula);
        checkNegative(numbers);
        return sum(numbers);
    }

    private static void checkNegative(String[] numbers) {

        for (String number : numbers) {
            int i = Integer.parseInt(number);
            if (i < 0) {
                throw new RuntimeException("negative parameter");
            }
        }
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static String[] split(String formula) {
        Matcher matcher = Pattern.compile(REGEX).matcher(formula);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return formula.split(DELIMITER);
    }

    private static boolean isNullOrEmpty(String formula) {
        return formula == null || EMPTY_STRING.equals(formula);
    }
}
