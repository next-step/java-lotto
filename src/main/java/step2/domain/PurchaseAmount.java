package step2.domain;

import step2.domain.lotto.LottoCount;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public double getWinningRate(long winningAmount) {
        return (double) winningAmount / this.amount;
    }

    public LottoCount getLottoCount(int lottoPrice) {
        if (isInvalidPurchaseAmount(lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }

        return new LottoCount(amount / lottoPrice);
    }

    private boolean isInvalidPurchaseAmount(int lottoPrice) {
        return this.amount < lottoPrice || this.amount % lottoPrice != 0;
    }
}
