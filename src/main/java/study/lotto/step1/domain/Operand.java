package study.lotto.step1.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public class Operand {
    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";
    private final BigDecimal value;

    public Operand(BigDecimal operand) {
        this.value = operand;
    }

    public Operand(String operand) {
        validateOperand(operand);
        this.value = new BigDecimal(operand);
    }

    public BigDecimal value() {
        return value;
    }

    public String plainString() {
        return value.toPlainString();
    }

    private void validateOperand(String operand) {
        if(!Pattern.matches(NUMBER_PATTERN, operand)) {
            throw new IllegalArgumentException("올바른 피연산자가 아닙니다: " + operand);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return Objects.equals(value, operand.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
