package lotto.exception;

public class LotteryGameException extends RuntimeException {

    public LotteryGameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
