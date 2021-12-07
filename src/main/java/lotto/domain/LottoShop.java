package lotto.domain;

public class LottoShop {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MIN_BUY_ROUND = 1;

    private final int purchaseAmount;
    private final int buyRound;

    public LottoShop(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.buyRound = getBuyRound();
    }

    public int getBuyRound() {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount / MIN_PURCHASE_AMOUNT < MIN_BUY_ROUND){
            throw new IllegalArgumentException("1000원 이상 입력되어야 합니다.");
        }
    }
}
