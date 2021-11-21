package lotto.model;

import lotto.generator.NumberGenerator;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final int number;

    public LottoNumber(NumberGenerator generator) {
        this.number = generator.generate();
    }

    public LottoNumber(int input) {
        this.number = invalid(input);
    }

    public LottoNumber(String input) {
        this.number = invalid(input);
    }

    private int invalid(int number) {
        if (rangeCheck(number)) {
            return number;
        }
        throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자입니다.");
    }

    private int invalid(String input) throws IllegalArgumentException {
        try {
            return invalid(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("로또 번호에는 1~45 사이의 숫자만 가능합니다.");
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
