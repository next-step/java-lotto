package step2.exception;

public class NotFoundPrizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "당첨 정보를 찾을 수 없습니다";

    public NotFoundPrizeException() {
        super(ERROR_MESSAGE);
    }

}
