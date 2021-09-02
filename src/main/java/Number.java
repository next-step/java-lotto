import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";

    private String delimiter;
    private List<String> numbers;

    Number(String delimiter, String[] numbers) {
        this.delimiter = delimiter;
        this.numbers = Arrays.asList(numbers);
        // todo number 따로 빼서 생성시 validate 하도록 (숫자 이외, 음수)
    }

    public static Number createNumber(String text) {
        final String first = extractFirstString(text);

        if (isNumber(first)) {
            return new Number(BASIC_DELIMITER, text.split(BASIC_DELIMITER));
        }

        final Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return new Number(customDelimiter, matcher.group(2).split(customDelimiter));
        }
        throw new RuntimeException();
    }

    static String extractFirstString(String text) {
        return String.valueOf(text.charAt(0));
    }

    static boolean isNumber(String first) {
        return Pattern.matches("\\d", first);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return Objects.equals(delimiter, number.delimiter) && Objects.equals(numbers, number.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter, numbers);
    }
}
