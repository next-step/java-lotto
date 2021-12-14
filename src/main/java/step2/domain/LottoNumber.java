package step2.domain;

import step2.exception.LottoException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTONUMBER = 1;
    public static final int MAX_LOTTONUMBER = 45;
    private final int number;

    private LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static LottoNumber from(String number) {
        int lottoNumber = toInt(number);
        return new LottoNumber(lottoNumber);

    }

    private static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException("로또 번호는 숫자만 가능합니다.");
        }
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validateRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTONUMBER || lottoNumber > MAX_LOTTONUMBER) {
            throw new LottoException("로또 번호는 " + MIN_LOTTONUMBER + "과 " + MAX_LOTTONUMBER + "번 사이여야합니다");
        }
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

    @Override
    public int compareTo(LottoNumber o) {
        if (this.number > o.getNumber()) {
            return 1;
        }
        return -1;
    }
}
