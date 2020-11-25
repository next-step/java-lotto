package study.lotto.core.exception;

public class AlreadyLotteryLottoException extends RuntimeException{

    private static final String message = "이미 추첨한 로또입니다.";

    public AlreadyLotteryLottoException() {
        super(message);
    }

}
