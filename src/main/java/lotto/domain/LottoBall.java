package lotto.domain;

public class LottoBall implements Comparable<LottoBall> {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public static final int DUPLICATED = 0;
    private static final int SWITCH_POSITION = 1;
    private static final int STAY_POSITION = -1;

    public final int number;

    public LottoBall(int number) {
        isLottoNumber(number);
        this.number = number;
    }

    @Override
    public int compareTo(LottoBall o) {

        if (this.number > o.number) {
            return SWITCH_POSITION;
        }
        
        if (this.number == o.number) {
            return DUPLICATED;
        }
        
        return STAY_POSITION;
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