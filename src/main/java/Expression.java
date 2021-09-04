import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";

    private String delimiter;
    private Numbers numbers;

    Expression(String delimiter, String[] numbers) {
        this.delimiter = delimiter;
        this.numbers = new Numbers(Arrays.asList(numbers));
    }

    public Number add() {
        return this.numbers.add();
    }

    public static Expression createExpression(String text) {
        if (text == null || text.isEmpty()) {
            return new Expression(BASIC_DELIMITER, new String[]{"0"});
        }

        final String first = extractFirstString(text);
        if (isNumber(first)) {
            return new Expression(BASIC_DELIMITER, text.split(BASIC_DELIMITER));
        }

        final Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return new Expression(customDelimiter, matcher.group(2).split(customDelimiter));
        }
        throw new RuntimeException("표현식 생성에 실패했습니다.");
    }

    private static String extractFirstString(String text) {
        return String.valueOf(text.charAt(0));
    }

    private static boolean isNumber(String first) {
        return Pattern.matches("\\d", first);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression number = (Expression) o;
        return Objects.equals(delimiter, number.delimiter) && Objects.equals(numbers, number.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter, numbers);
    }
}
