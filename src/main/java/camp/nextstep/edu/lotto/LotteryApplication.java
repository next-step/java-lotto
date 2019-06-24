package camp.nextstep.edu.lotto;

public class LotteryApplication {

    private static final int MINIMUM_INVESTMENT = 0;
    private static final int PRICE_OF_LOTTERY = 1000;

    public int calculateNumberOfAvailableLotteries(int investment) {
        if (investment < MINIMUM_INVESTMENT) {
            throw new IllegalArgumentException("'investment' must be greater than " + MINIMUM_INVESTMENT);
        }
        return investment / PRICE_OF_LOTTERY;
    }
}
