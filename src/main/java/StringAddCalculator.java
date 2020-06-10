import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final int ONE = 1;
    private static final int ZERO = 0;

    public static int splitAndSum(String expression) {
        if(isEmpty(expression)) {
            return ZERO;
        }

        if(ONE == expression.length()) {
           return makeInteger(expression);
        }

        return makeTokens(expression).stream()
                .mapToInt(t -> makeInteger(t))
                .sum();
    }

    private static boolean isEmpty(String str) {
        return (null == str || str.isEmpty());
    }

    private static int makeInteger(String stringNumber) {
        int parsedInt = Integer.parseInt(stringNumber);

        if(ZERO > parsedInt) {
            throw new NumberFormatException("음수입니다");
        }

        return parsedInt;
    }

    private static List<String> makeTokens(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return Arrays.asList(tokens);
        }
        return Arrays.asList(expression.split(DEFAULT_SEPARATOR));
    }
}
