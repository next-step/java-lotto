package lotto.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final Pattern pattern = Pattern.compile("[0-9]+");
    private static Integer MIN_NUMBER = 1;
    private static Integer MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String numberValue) {
        this(toIntValue(numberValue));
    }

    private void validate(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return;
        }

        throw new IllegalArgumentException("1 - 45 사이 숫자를 입력해주세요");
    }

    private static int toIntValue(String numberValue) {
        if (pattern.matcher(numberValue).matches()) {
            return Integer.parseInt(numberValue);
        }

        throw new IllegalArgumentException("숫자를 입력해주세요");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number > o.number) {
            return 1;
        }

        return this.number == o.number ? 0 : -1;
    }
}
