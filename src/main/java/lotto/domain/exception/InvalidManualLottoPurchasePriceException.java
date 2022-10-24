package lotto.domain.exception;

public class InvalidManualLottoPurchasePriceException extends RuntimeException {

    public InvalidManualLottoPurchasePriceException(int price) {
        super("마킹한 티켓들을 발권하기엔 투입금액이 적거나 너무 많습니다. 로또 한장 당 " + price + "원입니다.");
    }

}
