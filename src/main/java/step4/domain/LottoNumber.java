package step4.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int START_NUM = 1;
    public static final int END_NUM = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < START_NUM || number > END_NUM)
            throw new IllegalArgumentException("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
