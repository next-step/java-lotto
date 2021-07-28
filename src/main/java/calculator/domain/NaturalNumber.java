package calculator.domain;

import static calculator.utils.NaturalNumberUtil.isNotNaturalNumber;
import static java.lang.Integer.*;

public class NaturalNumber {
    private final int number;

    private NaturalNumber(String input) throws NumberFormatException {
        validate(input);
        this.number = parseInt(input);
    }

    private NaturalNumber(int input) {
        this.number = input;
    }

    private void validate(String numberString) {
        if (isNotNaturalNumber(numberString)) {
            throw new RuntimeException("숫자가 아닙니다: " + numberString);
        }
    }

    public static NaturalNumber of(String input) {
        return new NaturalNumber(input);
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    public NaturalNumber add(NaturalNumber otherNumber) {
        return new NaturalNumber(this.number + otherNumber.toInt());
    }

    public int toInt() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NaturalNumber that = (NaturalNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
