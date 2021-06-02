package lotto.exception;

public class BuyCountErrorException extends RuntimeException {
    public static final String MANUAL_BUY_COUNT_ERROR = "수동 구매 개수가 총 구매 개수 보다 클 수 없습니다.";

    public BuyCountErrorException() {
        super(MANUAL_BUY_COUNT_ERROR);
    }

    public BuyCountErrorException(String message) {
        super(message);
    }
}


