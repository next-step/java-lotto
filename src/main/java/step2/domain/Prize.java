package step2.domain;

public class Prize {
    private static final int LOTTO_PRIZE = 1000;

    private static final int THIRD_PRIZE = 5000;
    private static final int FOURTH_PRIZE = 50000;
    private static final int FIFTH_PRIZE = 1500000;
    private static final int SIXTH_PRIZE = 2000000000;

    public int getLottoCount(int monney) {
        return monney / LOTTO_PRIZE;
    }
}
