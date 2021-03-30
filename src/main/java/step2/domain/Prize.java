package step2.domain;

public class Prize {
    private static final int LOTTO_PRIZE = 1000;

    public int getLottoCount(int monney) {
        return monney / LOTTO_PRIZE;
    }
}
