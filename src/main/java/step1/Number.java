package step1;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(String value) throws NumberFormatException {
        this(Integer.parseInt(value));
    }

    public Number(int value) {
        this.value = value;
    }

    public Number operate(OperationStrategy operationStrategy, Number operand) {
        int result = operationStrategy.operate(this.value, operand.value);
        return new Number(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
