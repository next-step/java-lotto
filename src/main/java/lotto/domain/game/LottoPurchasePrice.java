package lotto.domain.game;

public class LottoPurchasePrice {

  private final int purchasePrice;
  private final int gameCount;

  public LottoPurchasePrice (int pricePerGame, int purchasePrice) {
    this.purchasePrice = purchasePrice;
    this.gameCount = calculateAndSetGameCount(pricePerGame);
  }

  public int getPurchasePrice() {
    return purchasePrice;
  }

  public int getGameCount() {
    return gameCount;
  }

  private int calculateAndSetGameCount(int pricePerGame) {
    if (purchasePrice % pricePerGame > 0) {
      throw new IllegalArgumentException();
    }
    return purchasePrice / pricePerGame;
  }
}
