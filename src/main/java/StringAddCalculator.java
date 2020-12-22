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
            return calculatorColonCommaDelimitor(input, sum);
        }
        Integer sum1 = calculateCustomDelimitor(input, sum);
        if (sum1 != null) return sum1;

        return 0;
    }

    private int calculatorColonCommaDelimitor(String input, int sum) {
        if (input.contains(COLON)) {
            String[] tokens = input.split(",|:");
            for (String num : tokens) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }

        return extractException(input, sum);
    }

    private int extractException(String input, int sum) {
        String[] numbers = input.split(COMMA);
        for (String num : numbers) {
            if (Integer.parseInt(num) < 0) {
                throw new RuntimeException("음수가 전달되었습니다.");
            }
            if (!Pattern.matches("^[0-9]$", num)) {
                throw new NumberFormatException("숫자 이외의 값이 전달되었습니다.");
            }
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private Integer calculateCustomDelimitor(String input, int sum) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            for (String num:tokens) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }
        return null;
    }
}
