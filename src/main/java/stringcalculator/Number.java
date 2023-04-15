package stringcalculator;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Number {

    public static Operation ADDITION = new Operation("+");
    public static Operation SUBTRACTION = new Operation("-");
    public static Operation MULTIPLICATION = new Operation("*");
    public static Operation DIVISION = new Operation("/");

    private int value;

    public Number(String value) {
        if (isEmpty(value)) {
            throw new InvalidParameterException("빈 숫자는 입력할 수 없습니다.");
        }
        this.value = toInt(value);
    }

    public Number(int value) {
        this.value = value;
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    private boolean isEmpty(String number) {
        return number == null || number.isBlank();
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
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int value() {
        return value;
    }

    public Number calculation(Operation operation, Number number) {
        if (isAddition(operation)) {
            return new Number(addition(number));
        }
        if (isSubtraction(operation)) {
            return new Number(subtraction(number));
        }
        if (isMultiplication(operation)) {
            return new Number(multiplication(number));
        }
        if (isDivision(operation)) {
            return new Number(division(number));
        }
        return new Number(this.value);
    }

    private boolean isDivision(Operation operation) {
        return operation.equals(DIVISION);
    }

    private int division(Number number) {
        return this.value / number.value();
    }

    private boolean isMultiplication(Operation operation) {
        return operation.equals(MULTIPLICATION);
    }

    private int multiplication(Number number) {
        return this.value * number.value();
    }

    private boolean isSubtraction(Operation operation) {
        return operation.equals(SUBTRACTION);
    }

    private int subtraction(Number number) {
        return this.value - number.value();
    }

    private int addition(Number number) {
        return this.value + number.value();
    }

    private boolean isAddition(Operation operation) {
        return operation.equals(ADDITION);
    }

}
