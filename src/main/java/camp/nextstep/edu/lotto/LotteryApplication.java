package camp.nextstep.edu.lotto;

public class LotteryApplication {

    private static final int MINIMUM_INVESTMENT = 0;

    public int calculateNumberOfAvailableLottery(int investment) {
        if (investment < MINIMUM_INVESTMENT) {
            throw new IllegalArgumentException("'investment' must be greater than " + MINIMUM_INVESTMENT);
        }
        return investment / 1000;
    }
}
