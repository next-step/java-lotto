package lotto.domain.exception;

public class NegativePriceException extends RuntimeException {

    public NegativePriceException() {
        super("금액은 음수가 될 수 없습니다.");
    }
}
