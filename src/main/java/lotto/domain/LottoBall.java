package lotto.domain;

import java.util.List;

public class LottoBall implements Comparable<LottoBall> {
    private int number;

    public LottoBall(int number) {
        if (number < LottoMachine.LOTTO_MIN_NUMBER || number > LottoMachine.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또볼은 1-45의 숫자로 가능합니다.");
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

        LottoBall lottoBall = (LottoBall) o;

        return number == lottoBall.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public int compareTo(LottoBall o) {
        return this.number < o.getNumber() ? -1
                : this.number > o.getNumber() ? 1 : 0;
    }

    @Override
    public String toString() {
        return  Integer.toString(number);
    }

    public boolean isIncludeIn(List<LottoBall> balls) {
        return balls.contains(this);
    }
}