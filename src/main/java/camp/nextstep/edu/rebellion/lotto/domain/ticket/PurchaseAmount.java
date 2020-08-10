package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;

public class PurchaseAmount {
    private final int LOTTO_PRICE = LottoGameRule.getLottoPrice();
    private final int LOTTO_PURCHASE_LIMIT = LottoGameRule.getLottoPurchaseLimit();

    private final int amount;
    private final int manualCount;

    public PurchaseAmount(int amount, int manualCount) {
        validatePrice(amount);
        validatePurchaseLimit(amount);
        validateManualCount(amount, manualCount);
        this.amount = amount;
        this.manualCount = manualCount;
    }

    public int getAutoCountOfPurchase() {
        return (this.amount / LOTTO_PRICE) - this.manualCount;
    }

    public int getManualCountOfPurchase() {
        return this.manualCount;
    }

    public double getReturnOfInvestment(long totalAward) {
        return totalAward / (double) amount;
    }

    private void validatePrice(int amount) {
        if (LOTTO_PRICE > amount) {
            throw new IllegalArgumentException("로또 최소 구매 금액은 "
                    + LOTTO_PRICE + " 원 입니다");
        }
    }

    private void validatePurchaseLimit(int amount) {
        if (LOTTO_PURCHASE_LIMIT < amount) {
            throw new IllegalArgumentException("로또 1회 한도 구매 금액은 "
                    + LOTTO_PURCHASE_LIMIT + " 원 입니다");
        }
    }

    private void validateManualCount(int amount, int manualCount) {
        if (manualCount > (amount / LOTTO_PRICE)) {
            throw new IllegalArgumentException("구매 금액을 초과 하였습니다");
        }
    }
}
