package lotto.domain;

import java.util.List;

public class FixedDrawingStrategy implements DrawingStrategy {

  private final List<Integer> fixedNumbers;

  public FixedDrawingStrategy(List<Integer> fixedNumbers) {
    this.fixedNumbers = fixedNumbers;
  }

  @Override
  public List<Integer> draw() {
    return fixedNumbers;
  }
}
