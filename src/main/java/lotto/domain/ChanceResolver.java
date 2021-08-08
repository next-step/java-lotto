package lotto.domain;

public class ChanceResolver {

    public static final int AMOUNT_FOR_CHANCE = 1000;

    public int resolveFromPurchaseAmount(int purchaseAmount) {
        return purchaseAmount / AMOUNT_FOR_CHANCE;
    }
}
