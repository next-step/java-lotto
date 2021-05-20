package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operand {

    private static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String ERROR_INVALID_OPERAND_INPUT = "0부터 9까지의 숫자만 입력해주세요.";

    private int number;


    public Operand(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void validateNumber(String number) throws IllegalArgumentException {
        Matcher numberMatcher = VALID_NUMBER_PATTERN.matcher(number);
        if (!numberMatcher.find()) {
            throw new IllegalArgumentException(ERROR_INVALID_OPERAND_INPUT);
        }
    }

    public int sumToTotal(int total) {
        return total + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operand operand = (Operand) o;
        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
