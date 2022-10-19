package stringcalculator;

import stringcalculator.arithmetic.ArithmeticOperation;

public class Number {

    private final int value;

    public Number(int number) {
        this.value = number;
    }

    public Number(String numberCandidate) {
        this.value = toInt(numberCandidate);
    }

    public Number calculate(Number anotherNumber, ArithmeticOperation operation) {
        int calculateValue = operation.calculate(this.value, anotherNumber.value);
        return new Number(calculateValue);
    }

    public int toInt() {
        return this.value;
    }

    private static int toInt(String numberCandidate) {
        try {
            return Integer.parseInt(numberCandidate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(numberCandidate + "는 숫자가 아닙니다. 올바른 형식인지 확인하세요");
        }
    }
}
