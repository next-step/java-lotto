package lotto;

public class LotteryGameException extends RuntimeException {

    public LotteryGameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
