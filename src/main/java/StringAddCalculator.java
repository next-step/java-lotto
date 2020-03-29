import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String EMPTY_STRING = "";
    public static final String DELIMITER = ",|:";
    public static final String REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String formula) {
        if (isNullOrEmpty(formula)) {
            return 0;
        }

        String[] numbers = split(formula);
        return sum(numbers);
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
