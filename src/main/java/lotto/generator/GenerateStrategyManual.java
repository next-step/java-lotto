package lotto.generator;

import lotto.domain.Lotto;

public class GenerateStrategyManual implements GenerateStrategy {
  private final String numbersList;

  public GenerateStrategyManual(String numbersList) {
    this.numbersList = numbersList;
  }

  @Override
  public Lotto generate() {
    return Lotto.of(numbersList);
  }
}
