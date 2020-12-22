import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String COMMA = ",";
    public static final int NUM_LENGTH = 1;
    public static final String COLON = ":";

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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
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
            extractException(num);
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private void extractException(String num) {
        if (Integer.parseInt(num) < 0) {
            throw new RuntimeException("음수가 전달되었습니다.");
        }
        if (!Pattern.matches("^[0-9]$", num)) {
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
