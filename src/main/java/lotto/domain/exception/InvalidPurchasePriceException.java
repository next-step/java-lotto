package lotto.domain.exception;

public class InvalidPurchasePriceException extends RuntimeException {

    public InvalidPurchasePriceException() {
        super("로또를 사기엔 투입 금액이 부족 합니다.");
    }

}
