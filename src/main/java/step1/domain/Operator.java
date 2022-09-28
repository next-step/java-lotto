package step1.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {

    private static final Pattern IS_OPERATOR = Pattern.compile("[+\\-*/]");

    private final char operator;

    public Operator(char operator) {
        validation(operator);
        this.operator = operator;
    }

    public char value() {
        return operator;
    }

    private void validation(char operator) {
        Matcher matcher = IS_OPERATOR.matcher(Character.toString(operator));
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator that = (Operator) o;
        return operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
