package lotto.exception;

public class PrizeCalculateException extends RuntimeException {
    public PrizeCalculateException() {
        super("Prize 를 도출할 수 없습니다");
    }
}
