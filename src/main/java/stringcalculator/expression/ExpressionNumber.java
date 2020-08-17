package stringcalculator.expression;

import stringcalculator.common.ExceptionMessage;
import stringcalculator.common.ExpressionValidator;

import java.util.Objects;

public class ExpressionNumber {
    private static final int DEFAULT_NUMBER = 0;
    private Integer number;

    private ExpressionNumber(String numberValue) {
        this.number = parseInt(numberValue);
    }

    private ExpressionNumber(int number) {
        this.number = number;
    }

    private Integer parseInt(String numberValue) {
        validateNumber(numberValue);

        return Integer.parseInt(numberValue);
    }

    private void validateNumber(String numberValue) {
        if (!ExpressionValidator.validNumber(numberValue)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUMBER.printMessage());
        }
    }

    public static ExpressionNumber newInstance(String numberValue) {
        return new ExpressionNumber(numberValue);
    }

    public static ExpressionNumber newInstance() {
        return new ExpressionNumber(DEFAULT_NUMBER);
    }

    public ExpressionNumber add(ExpressionNumber expressionNumber) {
        this.number = this.number + expressionNumber.number;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionNumber that = (ExpressionNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
