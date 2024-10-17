package calculator.domain;

import java.util.Objects;

public class OperandNumber {
    private static final String NUMBER_FORMAT_REGEX = "^(0|[-]?[1-9])$";
    private final Integer operand;

    public static OperandNumber create(String number) {
        validateNumberFormat(number);
        return new OperandNumber(Integer.valueOf(number));
    }

    private static void validateNumberFormat(String number) {
        if (!number.matches(NUMBER_FORMAT_REGEX)) {
            throw new NumberFormatException("정수(음수, 0, 양수) 형태의 문자열만 입력 가능합니다.");
        }
    }

    public OperandNumber(Integer number) {
        this.operand = number;
    }

    public OperandNumber plus(OperandNumber second) {
        return new OperandNumber(this.operand + second.operand);
    }

    public OperandNumber minus(OperandNumber second) {
        return new OperandNumber(this.operand - second.operand);
    }

    public OperandNumber multiply(OperandNumber second) {
        return new OperandNumber(this.operand * second.operand);
    }

    public OperandNumber divide(OperandNumber second) {
        if (second.isZero()) {
            throw new ArithmeticException("나눗셈 연산은 0으로 나눌 수 없습니다.");
        }
        return new OperandNumber(this.operand / second.operand);
    }

    private boolean isZero() {
        return this.operand == 0;
    }

    public Integer getValue() {
        return this.operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperandNumber that = (OperandNumber) o;
        return operand.equals(that.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
