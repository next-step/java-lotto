package lotto.domain;

public class LottoBall implements Comparable<LottoBall> {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public final int number;

    public LottoBall(int number) {
        isLottoNumber(number);
        this.number = number;
    }

    @Override
    public int compareTo(LottoBall o) {

        if (this.number > o.number) {
            return 1;
        }

        return -1;
    }

    private boolean isLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean equals(LottoBall lottoBall) {
        return this.number == lottoBall.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}