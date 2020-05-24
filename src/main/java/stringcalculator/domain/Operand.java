package stringcalculator.domain;

public class Operand {
    private final long value;

    public Operand(long value) {
        this.value = value;
    }

    public Operand(final String value) {
        try {
            long parsedValue = Long.parseLong(value);

            valid(parsedValue);

            this.value = parsedValue;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format("숫자가 아닌 %s는 더할 수 없습니다", value));
        }
    }

    private void valid(long value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("음수인 %d는 더할 수 없습니다", value));
        }
    }

    public static Operand add(Operand firstOperand, Operand secondOperand) {
        return new Operand(firstOperand.value + secondOperand.value);
    }

    public long getValue() {
        return value;
    }
}
