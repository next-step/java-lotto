package lotto.domain;

public class ChanceResolver {

    public static final int AMOUNT_FOR_CHANCE = 1_000;

    public Chance resolveFromPurchaseAmount(Money purchaseAmount) {
        return new Chance(purchaseAmount.getValue() / AMOUNT_FOR_CHANCE);
    }
}
