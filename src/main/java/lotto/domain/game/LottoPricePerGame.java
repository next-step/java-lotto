package lotto.domain.game;

public class LottoPricePerGame {

  private final int pricePerGame;

  public LottoPricePerGame(int pricePerGame) {
    throwIfInvalidPrice(pricePerGame);
    this.pricePerGame = pricePerGame;
  }

  private void throwIfInvalidPrice(int pricePerGame) {
    if(pricePerGame <= 0) {
      throw new IllegalArgumentException("로또 한 게임당 가격이 0이거나, 음수일 수 없습니다.");
    }
  }

  public int getPricePerGame() {
    return pricePerGame;
  }
}
