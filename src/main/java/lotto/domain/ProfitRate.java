package lotto.domain;

public class ProfitRate {

  private final double value;

  public ProfitRate(int gameCount, long rewordAll) {
    int purChaseAmount = gameCount * LottoGame.GAME_PRICE;
    this.value = (double) rewordAll / purChaseAmount;
  }

  public double getValue() {
    return value;
  }

}
