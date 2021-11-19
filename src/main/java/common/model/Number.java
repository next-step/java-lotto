package common.model;

import java.util.Objects;

import static calcalator.application.Constant.EXCEPTION_NUMBER_FORMAT_MESSAGE;
import static calcalator.application.Constant.EXCEPTION_NUMBER_NEGATIVE_MESSAGE;

public class Number {
    private int number;


    public Number() {
        this.number = 0;
    }

    public Number(String input) {
        this.number = parse(input);
    }

    public Number(int number) {
        this.number = number;
    }

    public void plus(Number other) {
        this.number += other.number;
    }

    public int parse(String input) {
        if (input == null || "".equals(input)) {
            return 0;
        }

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(EXCEPTION_NUMBER_FORMAT_MESSAGE);
        }

        if (number < 0) {
            throw new RuntimeException(EXCEPTION_NUMBER_NEGATIVE_MESSAGE);
        }

        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
