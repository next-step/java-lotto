package lotto.domain;

import java.util.List;

public class LottoBall implements Comparable<LottoBall> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private int number;

    public LottoBall(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
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
        return this.getNumber() - o.getNumber();
    }

    @Override
    public String toString() {
        return  Integer.toString(number);
    }

    public static LottoBall of(int number) {
        return new LottoBall(number);
    }
}