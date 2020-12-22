import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String COMMA = ",";
    private static final int NUM_LENGTH = 1;
    private static final String COLON = ":";
    private final Pattern numPattern = Pattern.compile("(^[0-9]$)");
    private final Pattern customPattern = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String input) {
        int sum = 0;
        if (input == null || input.isEmpty()) {
            return sum = 0;
        }
        if (input.length() == 1) {
            return sum = Integer.parseInt(input);
        }
        if (input.length() > NUM_LENGTH && input.contains(COMMA)) {
            return calculatorColonCommaDelimitor(input);
        }
        Matcher m = customPattern.matcher(input);
        if (m.find()) {
            return calculateMatcherSum(sum, m);
        }
        return sum;
    }

    private int calculatorColonCommaDelimitor(String input) {
        if (input.contains(COLON)) {
            String[] tokens = input.split(",|:");
            return getSum(tokens);
        }

        return commaDelimitor(input);
    }

    private int commaDelimitor(String input) {
        int sum = 0;
        String[] numbers = input.split(COMMA);
        for (String num : numbers) {
            int number = Integer.parseInt(num);
            extractException(number);
            sum += number;
        }
        return sum;
    }

    private void extractException(int num) {
        if (num < 0) {
            throw new RuntimeException("음수가 전달되었습니다.");
        }
        Matcher m = numPattern.matcher(Integer.toString(num));
        if (!m.find()) {
            throw new NumberFormatException("숫자 이외의 값이 전달되었습니다.");
        }
    }

    private int calculateMatcherSum(int sum, Matcher m) {
        String customDelimiter = m.group(1);
        String[] tokens = m.group(2).split(customDelimiter);
        return getSum(tokens);
    }

    private int getSum(String[] tokens) {
        int sum = 0;
        for (String num : tokens) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
