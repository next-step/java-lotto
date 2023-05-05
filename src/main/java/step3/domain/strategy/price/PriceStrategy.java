package step3.domain.strategy.price;

public interface PriceStrategy {
    int buyLotto(int purchaseAmount);

    int buyManualLotto(int purchaseAmount, int manualLottoCount);
}
