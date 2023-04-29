package step2.domain.strategy.price;

public class LottoPriceStrategy implements PriceStrategy {
    private static int LottoPurchase = 1000;

    @Override
    public int buyLotto(int purchaseAmount) {
        return purchaseAmount / LottoPurchase;
    }
}
