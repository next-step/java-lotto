package lotto.domain.exception;

public class InvalidLottoPurchasePriceException extends RuntimeException {

    public InvalidLottoPurchasePriceException() {
        super("로또를 사기엔 투입 금액이 부족 합니다.");
    }

}
