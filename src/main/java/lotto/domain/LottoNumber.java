package lotto.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String INVALID_NUMBER = "숫자는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + " 까지의 숫자만 가능합니다. 현재 숫자 : %d";

    private final int number;

    public LottoNumber(NumberText numberText) {
        this(numberText.getNumber());
    }

    public LottoNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER, number));
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
