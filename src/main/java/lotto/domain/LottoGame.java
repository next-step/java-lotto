package lotto.domain;

public class LottoGame {

    private static final int LOTTO_SALE_PRICE = 1000;

    private final int purchaseAmount;
    private final int purchaseCount;

    public LottoGame(int purchaseAmount) {
        validateLottoGame(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseAmount / LOTTO_SALE_PRICE;
    }

    private void validateLottoGame(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액이 1000원 이상 이어야 합니다.");
        }
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }
}
