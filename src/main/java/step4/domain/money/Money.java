package step4.domain.money;

import step4.domain.count.PassiveCount;
import step4.exception.InputNumberLessThanZeroException;

public final class Money {

    private static final int ZERO = 0;

    private final int money;

    private Money(int money) {
        validateRange(money);
        this.money = money;
    }

    public static final Money valueOf(int money) {
        return new Money(money);
    }

    private final void validateRange(int money) {
        if (money <= ZERO) {
            throw new InputNumberLessThanZeroException();
        }
    }

    public final boolean isNotAvailablePurchase(int itemAmount, int purchaseCount) {
        return money < (itemAmount * purchaseCount);
    }

    public final int availablePurchaseCount(int purchaseAmount, PassiveCount passiveCount) {
        return purchaseQuantity(purchaseAmount) - passiveCount.getCount();
    }

    private final int purchaseQuantity(int purchaseAmount) {
        validateRange(purchaseAmount);
        return money / purchaseAmount;
    }
}
