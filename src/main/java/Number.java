import java.util.Objects;
import java.util.regex.Pattern;

public class Number {

    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "숫자가 아닌 것은 입력할 수 없습니다.";
    private static final String LEGAL_NUMBER_PATTERN_REGEX = "\\d+";
    private static final Pattern LEGAL_NUMBER_PATTERN = Pattern.compile(LEGAL_NUMBER_PATTERN_REGEX);
    private static final int DEFAULT_NUMBER = 0;

    private final int number;

    public Number(String input) {
        validateArgument(input);
        this.number = toInteger(input);
    }

    public Number(int intInput) {
        this.number = intInput;
    }

    public Number plus(Number other) {
        return new Number(this.number + other.getNumber());
    }

    public int getNumber() {
        return number;
    }

    private void validateArgument(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        if (!LEGAL_NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    private int toInteger(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return DEFAULT_NUMBER;
        }

        return Integer.parseInt(inputString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
