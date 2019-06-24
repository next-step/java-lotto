package lotto.model;

import java.util.List;

public class Lotto {

  public static final int price = 1000;
  private final List<Integer> generatedNumbers;

  public Lotto(List<Integer> generatedNumbers) {
    this.generatedNumbers = generatedNumbers;
  }

  public int hasHowMany(List<Integer> winningNumbers) {
    return generatedNumbers.stream().reduce(0, (a, b) -> winningNumbers.contains(b) ? a + 1 : a);
  }

  @Override
  public String toString() {
    return generatedNumbers.toString();
  }
}
