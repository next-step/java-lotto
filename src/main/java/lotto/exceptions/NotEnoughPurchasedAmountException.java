package lotto.exceptions;

public class NotEnoughPurchasedAmountException extends RuntimeException {
    public NotEnoughPurchasedAmountException(int current, int need) {
        super("로또 구입 금액이 모자랍니다. 현재 돈: " + current + ", 수동 구입에 필요한 돈: " + need);
    }
}
