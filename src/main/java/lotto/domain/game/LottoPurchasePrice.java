package lotto.domain.game;

public class LottoPurchasePrice {

  private final int purchasePrice;
  private final int gameCount;

  public LottoPurchasePrice (LottoGameSetting gameSetting, int purchasePrice) {
    this.purchasePrice = purchasePrice;
    this.gameCount = calculateAndSetGameCount(gameSetting.getPricePerGame());
  }

  public int getPurchasePrice() {
    return purchasePrice;
  }

  public int getGameCount() {
    return gameCount;
  }

  private int calculateAndSetGameCount(LottoPricePerGame lottoPricePerGame) {
    int pricePerGame = lottoPricePerGame.getPricePerGame();
    if (purchasePrice % pricePerGame > 0) {
      throw new IllegalArgumentException();
    }
    return purchasePrice / pricePerGame;
  }
}
