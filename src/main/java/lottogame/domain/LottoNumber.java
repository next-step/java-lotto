package lottogame.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if (number < LottoGameConstants.MIN_LOTTO_NUMBER || number > LottoGameConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("유효한 로또 번호가 아닙니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.getNumber() - o.getNumber();
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
        return Objects.hashCode(number);
    }
}

