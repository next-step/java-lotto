package lotto;

import lotto.strategy.pick.NumberPickStrategy;
import lotto.strategy.shuffle.ShuffleStrategy;

public class LottoCreateStrategyContext {
  private final NumberPickStrategy numberPickStrategy;
  private final ShuffleStrategy shuffleStrategy;

  public LottoCreateStrategyContext(NumberPickStrategy numberPickStrategy, ShuffleStrategy shuffleStrategy) {
    this.numberPickStrategy = numberPickStrategy;
    this.shuffleStrategy = shuffleStrategy;
  }

  public NumberPickStrategy getNumberPickStrategy() {
    return numberPickStrategy;
  }

  public ShuffleStrategy getShuffleStrategy() {
    return shuffleStrategy;
  }
}
