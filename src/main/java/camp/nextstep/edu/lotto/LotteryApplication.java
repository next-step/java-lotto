package camp.nextstep.edu.lotto;

public class LotteryApplication {
    public int calculateNumberOfAvailableLottery(int investment) {
        if (investment < 0) {
            throw new IllegalArgumentException("'investment' must be greater than zero");
        }
        return 0;
    }
}
