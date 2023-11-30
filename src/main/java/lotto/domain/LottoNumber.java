package lotto.domain;

import java.util.Random;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        if (number < 1 || 45 < number ) {
            throw new IllegalArgumentException("로또 번호에 맞는 숫자여야합니다.");
        }

        this.number = number;
    }

    public static LottoNumber of(int lottoNumber) {


        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber defaultOf() {
        Random random = new Random();
        int lottoNumber = random.nextInt(45) + 1;
        return new LottoNumber(lottoNumber);
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
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
