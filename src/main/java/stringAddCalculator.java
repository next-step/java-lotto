import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class stringAddCalculator {

    public static final String REGEX_PATTERN = "//(.)\n(.*)";

    public static final Pattern pattern = Pattern.compile(REGEX_PATTERN);

    public int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInt(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private int[] toInt(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }

        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("입력에 음수가 포함될 수 없습니다.");
        }

        return number;
    }

    private String[] split(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(",|:");
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
