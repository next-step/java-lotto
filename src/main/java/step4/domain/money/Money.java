package step4.domain.money;

import step4.domain.count.PassiveCount;
import step4.exception.InputNegativeAmountException;

public final class Money {

    private static final int ZERO = 0;

    private final int money;

    private Money(int money) {
        validateNegative(money);
        this.money = money;
    }

    public static final Money valueOf(int money) {
        return new Money(money);
    }

    public final int purchaseQuantity(int purchaseAmount) {
        validateNegative(purchaseAmount);
        return money / purchaseAmount;
    }


    private final void validateNegative(int money) {
        if (money < ZERO) {
            throw new InputNegativeAmountException();
        }
    }

    private final void validateZeroOrNegative(int money) {
        if (money <= ZERO) {
            throw new InputNegativeAmountException();
        }
    }

    public final boolean isNotAvailablePurchase(int itemAmount, int purchaseCount) {
        return money < (itemAmount * purchaseCount);
    }

    public final int availablePurchaseCount(int itemAmount, PassiveCount passiveCount) {
        validateZeroOrNegative(itemAmount);
        return (money/itemAmount)-passiveCount.getCount();
    }
}
