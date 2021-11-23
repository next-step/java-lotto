package lotto.model;

import lotto.generator.NumberGenerator;

import java.util.Objects;

import static lotto.application.Constant.EXCEPTION_MESSAGE_PARSE_VALIDATION;
import static lotto.application.Constant.EXCEPTION_MESSAGE_RANGE_VALIDATION;

public class LottoNumber {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final int number;

    public LottoNumber(NumberGenerator generator) {
        this.number = generator.generate();
    }

    public LottoNumber(int input) {
        this.number = validate(input);
    }

    public LottoNumber(String input) {
        this.number = validate(input);
    }

    private int validate(int number) {
        if (rangeCheck(number)) {
            return number;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_RANGE_VALIDATION);
    }

    private int validate(String input) throws IllegalArgumentException {
        try {
            return validate(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PARSE_VALIDATION);
        }
    }

    private boolean rangeCheck(int number) {
        return MIN_RANGE <= number && number <= MAX_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
