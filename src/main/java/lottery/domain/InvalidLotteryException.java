package lottery.domain;

public class InvalidLotteryException extends RuntimeException {

    private static final String MESSAGE = "중복없는 번호 6개와 보너스 번호 1개로 구성되어야 합니다.";

    public InvalidLotteryException() {
        super(MESSAGE);
    }

}
