package study.lotto.exception;


public class WrongSelfPickCountException extends RuntimeException{

    private static final String MESSAGE = "구매 가능 개수를 초과하였습니다.";

    public WrongSelfPickCountException() {
        super(MESSAGE);
    }
}
