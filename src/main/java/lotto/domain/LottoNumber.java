package lotto.domain;

import java.util.Objects;

/**
 * @author han
 */
public class LottoNumber {
    private static final int BASE = 0;
    private static final int BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public LottoNumber(String input) {
        this(Integer.parseInt(input));
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < BASE || number > BOUND) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(number);
        return sb.toString();
    }
}
