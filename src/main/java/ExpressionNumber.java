import common.ExceptionMessage;

import java.util.Objects;

public class ExpressionNumber {
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

    public ExpressionNumber add(ExpressionNumber expressionNumber) {
        int result = this.number + expressionNumber.number;
        return new ExpressionNumber(result);
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
