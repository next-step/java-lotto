package lottery.domain;

public class ManualLotteryQuantityExceedException extends RuntimeException {

    private static final String MESSAGE = "수동으로 구매할 로또 개수가 발급할 로또 개수보다 많습니다.";

    public ManualLotteryQuantityExceedException() {
        super(MESSAGE);
    }

}
