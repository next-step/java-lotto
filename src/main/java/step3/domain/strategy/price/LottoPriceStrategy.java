package step3.domain.strategy.price;

public class LottoPriceStrategy implements PriceStrategy {
    private static int LottoPurchase = 1000;

    @Override
    public int buyLotto(int purchaseAmount) {
        return purchaseAmount / LottoPurchase;
    }

    @Override
    public int buyManualLotto(int purchaseAmount, int manualLottoCount) {
        purchaseAmount -= manualLottoCount * LottoPurchase;
        if (purchaseAmount < 0 ) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        return purchaseAmount;
    }
}
